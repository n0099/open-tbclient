package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes13.dex */
public class c {
    private static c eUt;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c bnu() {
        if (eUt == null) {
            synchronized (c.class) {
                if (eUt == null) {
                    eUt = new c();
                }
            }
        }
        return eUt;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
