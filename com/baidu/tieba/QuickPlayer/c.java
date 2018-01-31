package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public class c {
    private static c bNh;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Sw() {
        if (bNh == null) {
            synchronized (c.class) {
                if (bNh == null) {
                    bNh = new c();
                }
            }
        }
        return bNh;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
