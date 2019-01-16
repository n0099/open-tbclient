package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b fbk = null;
    private e fbl;

    private b() {
        this.fbl = null;
        this.fbl = new e(1000, 1000, 1000);
    }

    public static b aUV() {
        if (fbk == null) {
            synchronized (b.class) {
                if (fbk == null) {
                    fbk = new b();
                }
            }
        }
        return fbk;
    }

    public e hq() {
        return this.fbl;
    }
}
