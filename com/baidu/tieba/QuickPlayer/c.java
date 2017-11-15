package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aVY;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c KL() {
        if (aVY == null) {
            synchronized (c.class) {
                if (aVY == null) {
                    aVY = new c();
                }
            }
        }
        return aVY;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
