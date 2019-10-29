package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b gPs = null;
    private e gPt;

    private b() {
        this.gPt = null;
        this.gPt = new e(1000, 1000, 1000);
    }

    public static b bDE() {
        if (gPs == null) {
            synchronized (b.class) {
                if (gPs == null) {
                    gPs = new b();
                }
            }
        }
        return gPs;
    }

    public e eK() {
        return this.gPt;
    }
}
