package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eHf = null;
    private e eHg;

    private b() {
        this.eHg = null;
        this.eHg = new e(1000, 1000, 1000);
    }

    public static b aJQ() {
        if (eHf == null) {
            synchronized (b.class) {
                if (eHf == null) {
                    eHf = new b();
                }
            }
        }
        return eHf;
    }

    public e kZ() {
        return this.eHg;
    }
}
