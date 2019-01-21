package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f doQ = null;

    public static final f avp() {
        if (doQ == null) {
            synchronized (f.class) {
                if (doQ == null) {
                    doQ = new f();
                }
            }
        }
        return doQ;
    }

    private f() {
    }

    public boolean np(String str) {
        return true;
    }

    public boolean nq(String str) {
        return false;
    }
}
