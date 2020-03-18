package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes13.dex */
public class c {
    private static c dVq;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aWC() {
        if (dVq == null) {
            synchronized (c.class) {
                if (dVq == null) {
                    dVq = new c();
                }
            }
        }
        return dVq;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
