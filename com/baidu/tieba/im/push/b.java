package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b gIt = null;
    private e gIu;

    private b() {
        this.gIu = null;
        this.gIu = new e(1000, 1000, 1000);
    }

    public static b bDj() {
        if (gIt == null) {
            synchronized (b.class) {
                if (gIt == null) {
                    gIt = new b();
                }
            }
        }
        return gIt;
    }

    public e gh() {
        return this.gIu;
    }
}
