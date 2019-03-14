package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b grr = null;
    private e grs;

    private b() {
        this.grs = null;
        this.grs = new e(1000, 1000, 1000);
    }

    public static b bvA() {
        if (grr == null) {
            synchronized (b.class) {
                if (grr == null) {
                    grr = new b();
                }
            }
        }
        return grr;
    }

    public e hn() {
        return this.grs;
    }
}
