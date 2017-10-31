package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dKv = null;
    private e dKw;

    private b() {
        this.dKw = null;
        this.dKw = new e(1000, 1000, 1000);
    }

    public static b aAW() {
        if (dKv == null) {
            synchronized (b.class) {
                if (dKv == null) {
                    dKv = new b();
                }
            }
        }
        return dKv;
    }

    public e dv() {
        return this.dKw;
    }
}
