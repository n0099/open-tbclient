package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b gPx = null;
    private e gPy;

    private b() {
        this.gPy = null;
        this.gPy = new e(1000, 1000, 1000);
    }

    public static b bGf() {
        if (gPx == null) {
            synchronized (b.class) {
                if (gPx == null) {
                    gPx = new b();
                }
            }
        }
        return gPx;
    }

    public e gq() {
        return this.gPy;
    }
}
