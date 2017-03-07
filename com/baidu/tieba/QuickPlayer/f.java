package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class f {
    private static f aQd;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private f() {
        this.mHandlerThread.start();
    }

    public static f JA() {
        if (aQd == null) {
            synchronized (f.class) {
                if (aQd == null) {
                    aQd = new f();
                }
            }
        }
        return aQd;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
