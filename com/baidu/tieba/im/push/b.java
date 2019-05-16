package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b gIs = null;
    private e gIt;

    private b() {
        this.gIt = null;
        this.gIt = new e(1000, 1000, 1000);
    }

    public static b bDg() {
        if (gIs == null) {
            synchronized (b.class) {
                if (gIs == null) {
                    gIs = new b();
                }
            }
        }
        return gIs;
    }

    public e gh() {
        return this.gIt;
    }
}
