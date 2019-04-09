package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b grf = null;
    private e grg;

    private b() {
        this.grg = null;
        this.grg = new e(1000, 1000, 1000);
    }

    public static b bvx() {
        if (grf == null) {
            synchronized (b.class) {
                if (grf == null) {
                    grf = new b();
                }
            }
        }
        return grf;
    }

    public e hn() {
        return this.grg;
    }
}
