package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b gRr = null;
    private e gRs;

    private b() {
        this.gRs = null;
        this.gRs = new e(1000, 1000, 1000);
    }

    public static b bGT() {
        if (gRr == null) {
            synchronized (b.class) {
                if (gRr == null) {
                    gRr = new b();
                }
            }
        }
        return gRr;
    }

    public e gq() {
        return this.gRs;
    }
}
