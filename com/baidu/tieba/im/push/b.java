package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eQR = null;
    private e eQS;

    private b() {
        this.eQS = null;
        this.eQS = new e(1000, 1000, 1000);
    }

    public static b aRQ() {
        if (eQR == null) {
            synchronized (b.class) {
                if (eQR == null) {
                    eQR = new b();
                }
            }
        }
        return eQR;
    }

    public e hq() {
        return this.eQS;
    }
}
