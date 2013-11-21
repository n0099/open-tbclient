package com.baidu.tieba.im;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tieba.util.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public abstract class SingleRunnable<T> implements Runnable {
    protected static UIHandler d = new UIHandler();

    /* renamed from: a  reason: collision with root package name */
    private a<T> f1464a;

    public abstract T b();

    public void a(a<T> aVar) {
        this.f1464a = aVar;
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
            if (this.f1464a != null) {
                d.a(t, this.f1464a);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (nanoTime2 > 3000000000L) {
            y.a("use too long time:" + getClass().getName(), "background", (nanoTime2 / 1000000) + LocaleUtil.MALAY);
            com.baidu.adp.lib.h.d.a("后台" + getClass().getName() + "执行时间较长：" + (nanoTime2 / 1000000) + LocaleUtil.MALAY);
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
