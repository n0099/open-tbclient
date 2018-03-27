package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eLT = null;
    private e eLU;

    private b() {
        this.eLU = null;
        this.eLU = new e(1000, 1000, 1000);
    }

    public static b aLx() {
        if (eLT == null) {
            synchronized (b.class) {
                if (eLT == null) {
                    eLT = new b();
                }
            }
        }
        return eLT;
    }

    public e kZ() {
        return this.eLU;
    }
}
