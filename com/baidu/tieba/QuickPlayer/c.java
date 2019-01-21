package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes5.dex */
public class c {
    private static c byl;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Vc() {
        if (byl == null) {
            synchronized (c.class) {
                if (byl == null) {
                    byl = new c();
                }
            }
        }
        return byl;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
