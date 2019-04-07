package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c cJs;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c auY() {
        if (cJs == null) {
            synchronized (c.class) {
                if (cJs == null) {
                    cJs = new c();
                }
            }
        }
        return cJs;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
