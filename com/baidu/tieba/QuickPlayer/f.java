package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class f {
    private static f aQv;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private f() {
        this.mHandlerThread.start();
    }

    public static f Ka() {
        if (aQv == null) {
            synchronized (f.class) {
                if (aQv == null) {
                    aQv = new f();
                }
            }
        }
        return aQv;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
