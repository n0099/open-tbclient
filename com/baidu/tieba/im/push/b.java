package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dzi = null;
    private e dzj;

    private b() {
        this.dzj = null;
        this.dzj = new e(1000, 1000, 1000);
    }

    public static b axZ() {
        if (dzi == null) {
            synchronized (b.class) {
                if (dzi == null) {
                    dzi = new b();
                }
            }
        }
        return dzi;
    }

    public e dF() {
        return this.dzj;
    }
}
