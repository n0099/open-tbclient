package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b hIv = null;
    private e hIw;

    private b() {
        this.hIw = null;
        this.hIw = new e(1000, 1000, 1000);
    }

    public static b bXB() {
        if (hIv == null) {
            synchronized (b.class) {
                if (hIv == null) {
                    hIv = new b();
                }
            }
        }
        return hIv;
    }

    public e ff() {
        return this.hIw;
    }
}
