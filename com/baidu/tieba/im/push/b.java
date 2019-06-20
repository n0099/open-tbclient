package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b gIv = null;
    private e gIw;

    private b() {
        this.gIw = null;
        this.gIw = new e(1000, 1000, 1000);
    }

    public static b bDk() {
        if (gIv == null) {
            synchronized (b.class) {
                if (gIv == null) {
                    gIv = new b();
                }
            }
        }
        return gIv;
    }

    public e gh() {
        return this.gIw;
    }
}
