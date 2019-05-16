package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c cRC;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aAd() {
        if (cRC == null) {
            synchronized (c.class) {
                if (cRC == null) {
                    cRC = new c();
                }
            }
        }
        return cRC;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
