package com.baidu.tieba.barcode.b;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
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

    /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: java.lang.Class<T>, java.lang.Class<U> */
    public T a() {
        for (Integer num : this.c.keySet()) {
            if (Build.VERSION.SDK_INT >= num.intValue()) {
                try {
                    return (T) Class.forName(this.c.get(num)).asSubclass((Class<T>) this.a).getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException e) {
                    BdLog.detailException(e);
                } catch (IllegalAccessException e2) {
                    BdLog.detailException(e2);
                } catch (InstantiationException e3) {
                    BdLog.detailException(e3);
                } catch (NoSuchMethodException e4) {
                    BdLog.detailException(e4);
                } catch (InvocationTargetException e5) {
                    BdLog.detailException(e5);
                }
            }
        }
        return this.b;
    }
}
