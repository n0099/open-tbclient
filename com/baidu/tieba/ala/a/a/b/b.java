package com.baidu.tieba.ala.a.a.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class b {
    public static Object a(Class<?> cls, Class<?>[] clsArr, Object[] objArr) {
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        Field declaredField = getDeclaredField(obj, str);
        if (declaredField != null) {
            declaredField.setAccessible(true);
            try {
                declaredField.set(obj, obj2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Object getFieldValue(Object obj, String str) {
        Field declaredField = getDeclaredField(obj, str);
        if (declaredField != null) {
            declaredField.setAccessible(true);
            try {
                return declaredField.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static Field getDeclaredField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e) {
            }
        }
        return null;
    }
}
