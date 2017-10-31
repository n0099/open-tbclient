package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aVQ;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c KA() {
        if (aVQ == null) {
            synchronized (c.class) {
                if (aVQ == null) {
                    aVQ = new c();
                }
            }
        }
        return aVQ;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
