package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f iro = null;

    public static final f ctV() {
        if (iro == null) {
            synchronized (f.class) {
                if (iro == null) {
                    iro = new f();
                }
            }
        }
        return iro;
    }

    private f() {
    }

    public boolean JB(String str) {
        return true;
    }

    public boolean JC(String str) {
        return false;
    }
}
