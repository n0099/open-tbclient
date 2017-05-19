package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class f {
    private static f aQO;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private f() {
        this.mHandlerThread.start();
    }

    public static f Jo() {
        if (aQO == null) {
            synchronized (f.class) {
                if (aQO == null) {
                    aQO = new f();
                }
            }
        }
        return aQO;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
