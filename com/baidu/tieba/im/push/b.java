package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eLP = null;
    private e eLQ;

    private b() {
        this.eLQ = null;
        this.eLQ = new e(1000, 1000, 1000);
    }

    public static b aLx() {
        if (eLP == null) {
            synchronized (b.class) {
                if (eLP == null) {
                    eLP = new b();
                }
            }
        }
        return eLP;
    }

    public e kZ() {
        return this.eLQ;
    }
}
