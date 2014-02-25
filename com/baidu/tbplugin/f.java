package com.baidu.tbplugin;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class f {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Class<T extends java.lang.annotation.Annotation> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Annotation> T a(Class<?> cls, Class<T> cls2) {
        return (T) cls.getAnnotation(cls2);
    }

    public static int a(int i, int i2) {
        return (i << 8) | i2;
    }

    public static File a() {
        return j.a().c();
    }

    public static File b() {
        return j.a().d();
    }

    public static File c() {
        return j.a().e();
    }

    public static File d() {
        return j.a().f();
    }

    public static File e() {
        return j.a().g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Field a(Class<?> cls, String str) {
        Field[] declaredFields;
        for (Field field : cls.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            if (field.getName().equals(str)) {
                return field;
            }
        }
        return null;
    }

    public static String f() {
        String substring = System.getProperty("os.arch", "arm").substring(0, 3);
        if (substring.equals("i68")) {
            return "x86";
        }
        return substring;
    }
}
