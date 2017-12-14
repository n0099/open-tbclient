package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aZb;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Lh() {
        if (aZb == null) {
            synchronized (c.class) {
                if (aZb == null) {
                    aZb = new c();
                }
            }
        }
        return aZb;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
