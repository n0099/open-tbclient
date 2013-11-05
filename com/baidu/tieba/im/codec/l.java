package com.baidu.tieba.im.codec;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f1482a = new l();

    public static l a() {
        return f1482a;
    }

    private l() {
    }

    public Map<String, String> a(Object obj) {
        HashMap hashMap = new HashMap();
        if (obj == null) {
            return hashMap;
        }
        for (Map.Entry<String, Method> entry : a(obj.getClass()).entrySet()) {
            try {
                Object invoke = entry.getValue().invoke(obj, new Object[0]);
                if (invoke == null) {
                    hashMap.put(entry.getKey(), null);
                } else {
                    hashMap.put(entry.getKey(), invoke.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return hashMap;
    }

    protected Map<String, Method> a(Class<?> cls) {
        return b(cls);
    }

    protected Map<String, Method> b(Class<?> cls) {
        String substring;
        String str;
        Method[] methods = cls.getMethods();
        HashMap hashMap = new HashMap();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && !Void.TYPE.equals(method.getReturnType()) && method.getParameterTypes().length == 0 && j.a(method.getReturnType().getName()) != null) {
                String name = method.getName();
                if (!"getClass".equals(name)) {
                    if (name.startsWith("get")) {
                        substring = name.substring(3);
                    } else if (name.startsWith("is") && Boolean.TYPE.equals(method.getReturnType())) {
                        substring = name.substring(2);
                    }
                    if (substring.length() == 1) {
                        str = substring.toLowerCase();
                    } else {
                        str = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                    }
                    hashMap.put(str, method);
                }
            }
        }
        return hashMap;
    }
}
