package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public class c {
    private static c bMZ;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Su() {
        if (bMZ == null) {
            synchronized (c.class) {
                if (bMZ == null) {
                    bMZ = new c();
                }
            }
        }
        return bMZ;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
