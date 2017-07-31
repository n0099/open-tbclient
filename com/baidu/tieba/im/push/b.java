package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dxl = null;
    private e dxm;

    private b() {
        this.dxm = null;
        this.dxm = new e(1000, 1000, 1000);
    }

    public static b axs() {
        if (dxl == null) {
            synchronized (b.class) {
                if (dxl == null) {
                    dxl = new b();
                }
            }
        }
        return dxl;
    }

    public e dF() {
        return this.dxm;
    }
}
