package com.baidu.tieba.im;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public abstract class b<T> implements Runnable {
    protected static c a = new c();
    private a<T> b;

    public abstract T a();

    public void a(a<T> aVar) {
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long nanoTime = System.nanoTime();
        T t = null;
        try {
            t = a();
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
        try {
            if (this.b != null) {
                a.a(t, this.b);
            }
        } catch (Throwable th2) {
            BdLog.detailException(th2);
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (nanoTime2 > 3000000000L) {
            TiebaStatic.imLog("use too long time:" + getClass().getName(), "background", String.valueOf(nanoTime2 / 1000000) + "ms");
        }
    }
}
