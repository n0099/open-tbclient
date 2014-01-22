package com.baidu.tieba.im;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tieba.util.by;
/* loaded from: classes.dex */
public abstract class SingleRunnable<T> implements Runnable {
    protected static UIHandler d = new UIHandler();
    private a<T> a;

    public abstract T b();

    public void a(a<T> aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long nanoTime = System.nanoTime();
        T t = null;
        try {
            t = b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.a != null) {
                d.a(t, this.a);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (nanoTime2 > 3000000000L) {
            by.b("use too long time:" + getClass().getName(), "background", (nanoTime2 / 1000000) + "ms");
            com.baidu.adp.lib.g.e.a("后台" + getClass().getName() + "执行时间较长：" + (nanoTime2 / 1000000) + "ms");
        }
    }

    /* loaded from: classes.dex */
    public class UIHandler extends Handler {
        public UIHandler() {
            super(Looper.getMainLooper());
        }

        public synchronized <T> void a(T t, a<T> aVar) {
            post(new h(this, aVar, t));
        }
    }
}
