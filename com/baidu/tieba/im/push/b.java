package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b hIh = null;
    private e hIi;

    private b() {
        this.hIi = null;
        this.hIi = new e(1000, 1000, 1000);
    }

    public static b bXy() {
        if (hIh == null) {
            synchronized (b.class) {
                if (hIh == null) {
                    hIh = new b();
                }
            }
        }
        return hIh;
    }

    public e ff() {
        return this.hIi;
    }
}
