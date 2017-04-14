package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class f {
    private static f aQt;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private f() {
        this.mHandlerThread.start();
    }

    public static f Ka() {
        if (aQt == null) {
            synchronized (f.class) {
                if (aQt == null) {
                    aQt = new f();
                }
            }
        }
        return aQt;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
