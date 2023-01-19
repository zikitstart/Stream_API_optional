import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        findMinMax(Stream.of(), Comparator.comparingInt(String::length), (min, max) -> System.out.println("min = " + min + " / max = " + max));
        findMinMax(Stream.of("Тест1", "Тест2", "Тест1714", "Тест177", "Тест130", "Тест14"), Comparator.comparingInt(String::length), (min, max) -> System.out.println("min = " + min + " / max = " + max));
        findMinMax(Stream.of(460, 32, 44, 277, 30, 14), Comparator.comparingInt(Integer::intValue), (min, max) -> System.out.println("min = " + min + " / max = " + max));
        System.out.println();

        List<Integer> list = List.of(463, 32, 45, 277, 30, 17, 30, 30, 30, 30, 30);
        evenNumbers(list);
    }

    public static <T> void findMinMax(Stream<T> stream,
                                      Comparator<T> order,
                                      BiConsumer<T, T> minMaxConsumer) {
        List<T> items = stream.sorted(order).toList();

        if (items.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = items.get(0);
            T max = items.get(items.size() - 1);
            minMaxConsumer.accept(min, max);
        }
    }

    public static void evenNumbers(List<Integer> list) {
        List<Integer> list1 = list.stream().filter(num -> num % 2 == 0).toList();
        System.out.println("Количество четных чисел: " + list1.size());
    }
}