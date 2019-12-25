package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b hCF = null;
    private e hCG;

    private b() {
        this.hCG = null;
        this.hCG = new e(1000, 1000, 1000);
    }

    public static b bUO() {
        if (hCF == null) {
            synchronized (b.class) {
                if (hCF == null) {
                    hCF = new b();
                }
            }
        }
        return hCF;
    }

    public e fe() {
        return this.hCG;
    }
}
