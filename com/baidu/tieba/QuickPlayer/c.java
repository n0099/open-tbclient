package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public class c {
    private static c bpi;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Rt() {
        if (bpi == null) {
            synchronized (c.class) {
                if (bpi == null) {
                    bpi = new c();
                }
            }
        }
        return bpi;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
