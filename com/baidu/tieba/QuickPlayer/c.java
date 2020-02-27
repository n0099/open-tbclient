package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes13.dex */
public class c {
    private static c dUM;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aWv() {
        if (dUM == null) {
            synchronized (c.class) {
                if (dUM == null) {
                    dUM = new c();
                }
            }
        }
        return dUM;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
