package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eAy = null;
    private e eAz;

    private b() {
        this.eAz = null;
        this.eAz = new e(1000, 1000, 1000);
    }

    public static b aMQ() {
        if (eAy == null) {
            synchronized (b.class) {
                if (eAy == null) {
                    eAy = new b();
                }
            }
        }
        return eAy;
    }

    public e fR() {
        return this.eAz;
    }
}
