package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f cPs = null;

    public static final f anE() {
        if (cPs == null) {
            synchronized (f.class) {
                if (cPs == null) {
                    cPs = new f();
                }
            }
        }
        return cPs;
    }

    private f() {
    }

    public boolean lq(String str) {
        return true;
    }

    public boolean lr(String str) {
        return false;
    }
}
