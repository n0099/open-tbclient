package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c cJt;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c auY() {
        if (cJt == null) {
            synchronized (c.class) {
                if (cJt == null) {
                    cJt = new c();
                }
            }
        }
        return cJt;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
