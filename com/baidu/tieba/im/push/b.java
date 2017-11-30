package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dSo = null;
    private e dSp;

    private b() {
        this.dSp = null;
        this.dSp = new e(1000, 1000, 1000);
    }

    public static b aCA() {
        if (dSo == null) {
            synchronized (b.class) {
                if (dSo == null) {
                    dSo = new b();
                }
            }
        }
        return dSo;
    }

    public e dv() {
        return this.dSp;
    }
}
