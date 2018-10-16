package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes5.dex */
public class c {
    private static c bti;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Tp() {
        if (bti == null) {
            synchronized (c.class) {
                if (bti == null) {
                    bti = new c();
                }
            }
        }
        return bti;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
