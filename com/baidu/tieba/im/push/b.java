package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dTx = null;
    private e dTy;

    private b() {
        this.dTy = null;
        this.dTy = new e(1000, 1000, 1000);
    }

    public static b aCJ() {
        if (dTx == null) {
            synchronized (b.class) {
                if (dTx == null) {
                    dTx = new b();
                }
            }
        }
        return dTx;
    }

    public e dv() {
        return this.dTy;
    }
}
