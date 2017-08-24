package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aUF;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c JX() {
        if (aUF == null) {
            synchronized (c.class) {
                if (aUF == null) {
                    aUF = new c();
                }
            }
        }
        return aUF;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
