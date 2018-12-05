package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eXG = null;
    private e eXH;

    private b() {
        this.eXH = null;
        this.eXH = new e(1000, 1000, 1000);
    }

    public static b aTI() {
        if (eXG == null) {
            synchronized (b.class) {
                if (eXG == null) {
                    eXG = new b();
                }
            }
        }
        return eXG;
    }

    public e hq() {
        return this.eXH;
    }
}
