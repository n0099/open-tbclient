package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aVT;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Kx() {
        if (aVT == null) {
            synchronized (c.class) {
                if (aVT == null) {
                    aVT = new c();
                }
            }
        }
        return aVT;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
