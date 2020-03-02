package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes13.dex */
public class c {
    private static c dUN;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aWx() {
        if (dUN == null) {
            synchronized (c.class) {
                if (dUN == null) {
                    dUN = new c();
                }
            }
        }
        return dUN;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
