package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f cVg = null;

    public static final f apt() {
        if (cVg == null) {
            synchronized (f.class) {
                if (cVg == null) {
                    cVg = new f();
                }
            }
        }
        return cVg;
    }

    private f() {
    }

    public boolean lU(String str) {
        return true;
    }

    public boolean lV(String str) {
        return false;
    }
}
