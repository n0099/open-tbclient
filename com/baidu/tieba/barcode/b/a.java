package com.baidu.tieba.barcode.b;

import android.os.Build;
import com.baidu.adp.lib.util.e;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
/* loaded from: classes.dex */
public abstract class a<T> {
    private final Class<T> a;
    private final T b;
    private final SortedMap<Integer, String> c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Class<T> cls, T t) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException();
        }
        if (!cls.isInstance(t)) {
            throw new IllegalArgumentException();
        }
        this.a = cls;
        this.b = t;
        this.c = new TreeMap(Collections.reverseOrder());
    }

    /* JADX DEBUG: Type inference failed for r3v11. Raw type applied. Possible types: java.lang.Class<T>, java.lang.Class<U> */
    public final T a() {
        for (Integer num : this.c.keySet()) {
            if (Build.VERSION.SDK_INT >= num.intValue()) {
                try {
                    Class<? extends U> asSubclass = Class.forName(this.c.get(num)).asSubclass((Class<T>) this.a);
                    e.a(getClass().getName(), "build", "Using implementation " + asSubclass + " of " + this.a + " for SDK " + num);
                    return (T) asSubclass.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException e) {
                    e.c(getClass().getName(), "build", e.toString());
                } catch (IllegalAccessException e2) {
                    e.c(getClass().getName(), "build", e2.toString());
                } catch (InstantiationException e3) {
                    e.c(getClass().getName(), "build", e3.toString());
                } catch (NoSuchMethodException e4) {
                    e.c(getClass().getName(), "build", e4.toString());
                } catch (InvocationTargetException e5) {
                    e.c(getClass().getName(), "build", e5.toString());
                }
            }
        }
        e.a(getClass().getName(), "build", "Using default implementation " + this.b.getClass() + " of " + this.a);
        return this.b;
    }
}
