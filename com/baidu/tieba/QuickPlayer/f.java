package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class f {
    private static f aLY;
    private HandlerThread aLZ = new HandlerThread("PlayerHandlerThread");

    private f() {
        this.aLZ.start();
    }

    public static f Jn() {
        if (aLY == null) {
            synchronized (f.class) {
                if (aLY == null) {
                    aLY = new f();
                }
            }
        }
        return aLY;
    }

    public Looper getLooper() {
        return this.aLZ.getLooper();
    }
}
