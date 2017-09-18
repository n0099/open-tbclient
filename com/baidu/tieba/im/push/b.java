package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dGG = null;
    private e dGH;

    private b() {
        this.dGH = null;
        this.dGH = new e(1000, 1000, 1000);
    }

    public static b azU() {
        if (dGG == null) {
            synchronized (b.class) {
                if (dGG == null) {
                    dGG = new b();
                }
            }
        }
        return dGG;
    }

    public e dv() {
        return this.dGH;
    }
}
