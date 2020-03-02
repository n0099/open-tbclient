package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b hIj = null;
    private e hIk;

    private b() {
        this.hIk = null;
        this.hIk = new e(1000, 1000, 1000);
    }

    public static b bXA() {
        if (hIj == null) {
            synchronized (b.class) {
                if (hIj == null) {
                    hIj = new b();
                }
            }
        }
        return hIj;
    }

    public e ff() {
        return this.hIk;
    }
}
