package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c cRD;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aAg() {
        if (cRD == null) {
            synchronized (c.class) {
                if (cRD == null) {
                    cRD = new c();
                }
            }
        }
        return cRD;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
