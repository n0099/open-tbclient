package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c cJq;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c avb() {
        if (cJq == null) {
            synchronized (c.class) {
                if (cJq == null) {
                    cJq = new c();
                }
            }
        }
        return cJq;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
