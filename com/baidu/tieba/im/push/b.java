package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eFF = null;
    private e eFG;

    private b() {
        this.eFG = null;
        this.eFG = new e(1000, 1000, 1000);
    }

    public static b aJL() {
        if (eFF == null) {
            synchronized (b.class) {
                if (eFF == null) {
                    eFF = new b();
                }
            }
        }
        return eFF;
    }

    public e kZ() {
        return this.eFG;
    }
}
