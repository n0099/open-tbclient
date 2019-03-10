package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b grs = null;
    private e grt;

    private b() {
        this.grt = null;
        this.grt = new e(1000, 1000, 1000);
    }

    public static b bvB() {
        if (grs == null) {
            synchronized (b.class) {
                if (grs == null) {
                    grs = new b();
                }
            }
        }
        return grs;
    }

    public e hn() {
        return this.grt;
    }
}
