package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes13.dex */
public class c {
    private static c dVa;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aWy() {
        if (dVa == null) {
            synchronized (c.class) {
                if (dVa == null) {
                    dVa = new c();
                }
            }
        }
        return dVa;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
