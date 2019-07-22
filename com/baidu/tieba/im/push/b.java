package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b gOF = null;
    private e gOG;

    private b() {
        this.gOG = null;
        this.gOG = new e(1000, 1000, 1000);
    }

    public static b bFR() {
        if (gOF == null) {
            synchronized (b.class) {
                if (gOF == null) {
                    gOF = new b();
                }
            }
        }
        return gOF;
    }

    public e gq() {
        return this.gOG;
    }
}
