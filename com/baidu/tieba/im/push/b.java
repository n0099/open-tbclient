package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b hJV = null;
    private e hJW;

    private b() {
        this.hJW = null;
        this.hJW = new e(1000, 1000, 1000);
    }

    public static b bXT() {
        if (hJV == null) {
            synchronized (b.class) {
                if (hJV == null) {
                    hJV = new b();
                }
            }
        }
        return hJV;
    }

    public e ff() {
        return this.hJW;
    }
}
