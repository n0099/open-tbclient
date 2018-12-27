package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes5.dex */
public class c {
    private static c bxw;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c UG() {
        if (bxw == null) {
            synchronized (c.class) {
                if (bxw == null) {
                    bxw = new c();
                }
            }
        }
        return bxw;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
