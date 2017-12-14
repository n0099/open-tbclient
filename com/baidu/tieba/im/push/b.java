package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dTt = null;
    private e dTu;

    private b() {
        this.dTu = null;
        this.dTu = new e(1000, 1000, 1000);
    }

    public static b aCJ() {
        if (dTt == null) {
            synchronized (b.class) {
                if (dTt == null) {
                    dTt = new b();
                }
            }
        }
        return dTt;
    }

    public e dv() {
        return this.dTu;
    }
}
