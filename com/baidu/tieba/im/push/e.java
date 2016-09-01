package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e djE = null;
    private com.baidu.adp.framework.c.e djF;

    private e() {
        this.djF = null;
        this.djF = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e avK() {
        if (djE == null) {
            synchronized (e.class) {
                if (djE == null) {
                    djE = new e();
                }
            }
        }
        return djE;
    }

    public com.baidu.adp.framework.c.e co() {
        return this.djF;
    }
}
