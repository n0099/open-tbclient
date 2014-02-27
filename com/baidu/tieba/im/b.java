package com.baidu.tieba.im;

import com.baidu.tieba.util.cb;
/* loaded from: classes.dex */
public abstract class b<T> implements Runnable {
    protected static c b = new c();
    private a<T> a;

    public abstract T a();

    public final void a(a<T> aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long nanoTime = System.nanoTime();
        T t = null;
        try {
            t = a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.a != null) {
                b.a(t, this.a);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (nanoTime2 > 3000000000L) {
            cb.b("use too long time:" + getClass().getName(), "background", String.valueOf(nanoTime2 / 1000000) + "ms");
            com.baidu.adp.lib.util.e.b("后台" + getClass().getName() + "执行时间较长：" + (nanoTime2 / 1000000) + "ms");
        }
    }
}
