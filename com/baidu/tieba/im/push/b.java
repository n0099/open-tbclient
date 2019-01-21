package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b fbl = null;
    private e fbm;

    private b() {
        this.fbm = null;
        this.fbm = new e(1000, 1000, 1000);
    }

    public static b aUV() {
        if (fbl == null) {
            synchronized (b.class) {
                if (fbl == null) {
                    fbl = new b();
                }
            }
        }
        return fbl;
    }

    public e hq() {
        return this.fbm;
    }
}
