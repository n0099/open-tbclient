package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes11.dex */
public class c {
    private static c dQH;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aUf() {
        if (dQH == null) {
            synchronized (c.class) {
                if (dQH == null) {
                    dQH = new c();
                }
            }
        }
        return dQH;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
