package com.baidu.tieba.im;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public abstract class m<T> implements Runnable {
    protected static n a = new n();
    private a<T> b;

    public abstract T a();

    public final void a(a<T> aVar) {
        this.b = aVar;
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
            if (this.b != null) {
                a.a(t, this.b);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (nanoTime2 > 3000000000L) {
            TiebaStatic.b("use too long time:" + getClass().getName(), "background", String.valueOf(nanoTime2 / 1000000) + "ms");
            com.baidu.adp.lib.util.f.b("后台" + getClass().getName() + "执行时间较长：" + (nanoTime2 / 1000000) + "ms");
        }
    }
}
