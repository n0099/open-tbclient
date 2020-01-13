package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b hGi = null;
    private e hGj;

    private b() {
        this.hGj = null;
        this.hGj = new e(1000, 1000, 1000);
    }

    public static b bVX() {
        if (hGi == null) {
            synchronized (b.class) {
                if (hGi == null) {
                    hGi = new b();
                }
            }
        }
        return hGi;
    }

    public e fe() {
        return this.hGj;
    }
}
