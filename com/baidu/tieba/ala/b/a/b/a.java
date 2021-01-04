package com.baidu.tieba.ala.b.a.b;

import java.lang.reflect.Array;
/* loaded from: classes10.dex */
public class a {
    public static Object b(Class cls, Object[] objArr, Object obj) {
        Object newInstance = Array.newInstance(cls, objArr.length + 1);
        Array.set(newInstance, 0, obj);
        for (int i = 1; i < objArr.length + 1; i++) {
            Array.set(newInstance, i, objArr[i - 1]);
        }
        return newInstance;
    }

    public static <T> boolean c(T[] tArr, T t) {
        return d(tArr, t) != -1;
    }

    public static <T> int d(T[] tArr, T t) {
        if (tArr == null) {
            return -1;
        }
        for (int i = 0; i < tArr.length; i++) {
            if (equals(tArr[i], t)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
