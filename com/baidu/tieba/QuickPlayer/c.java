package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aZf;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Lh() {
        if (aZf == null) {
            synchronized (c.class) {
                if (aZf == null) {
                    aZf = new c();
                }
            }
        }
        return aZf;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
