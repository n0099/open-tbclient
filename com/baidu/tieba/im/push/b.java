package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b gOB = null;
    private e gOC;

    private b() {
        this.gOC = null;
        this.gOC = new e(1000, 1000, 1000);
    }

    public static b bDC() {
        if (gOB == null) {
            synchronized (b.class) {
                if (gOB == null) {
                    gOB = new b();
                }
            }
        }
        return gOB;
    }

    public e eK() {
        return this.gOC;
    }
}
