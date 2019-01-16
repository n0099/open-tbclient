package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes5.dex */
public class c {
    private static c byk;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Vc() {
        if (byk == null) {
            synchronized (c.class) {
                if (byk == null) {
                    byk = new c();
                }
            }
        }
        return byk;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
