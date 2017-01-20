package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e dcQ = null;
    private com.baidu.adp.framework.c.e dcR;

    private e() {
        this.dcR = null;
        this.dcR = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e atL() {
        if (dcQ == null) {
            synchronized (e.class) {
                if (dcQ == null) {
                    dcQ = new e();
                }
            }
        }
        return dcQ;
    }

    public com.baidu.adp.framework.c.e cm() {
        return this.dcR;
    }
}
