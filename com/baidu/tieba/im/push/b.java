package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b gre = null;
    private e grf;

    private b() {
        this.grf = null;
        this.grf = new e(1000, 1000, 1000);
    }

    public static b bvx() {
        if (gre == null) {
            synchronized (b.class) {
                if (gre == null) {
                    gre = new b();
                }
            }
        }
        return gre;
    }

    public e hn() {
        return this.grf;
    }
}
