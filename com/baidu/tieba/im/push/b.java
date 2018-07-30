package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eAC = null;
    private e eAD;

    private b() {
        this.eAD = null;
        this.eAD = new e(1000, 1000, 1000);
    }

    public static b aMT() {
        if (eAC == null) {
            synchronized (b.class) {
                if (eAC == null) {
                    eAC = new b();
                }
            }
        }
        return eAC;
    }

    public e fR() {
        return this.eAD;
    }
}
