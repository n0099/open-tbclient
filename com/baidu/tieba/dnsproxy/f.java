package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f doP = null;

    public static final f avp() {
        if (doP == null) {
            synchronized (f.class) {
                if (doP == null) {
                    doP = new f();
                }
            }
        }
        return doP;
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
