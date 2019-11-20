package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eWK = null;

    public static final f bcP() {
        if (eWK == null) {
            synchronized (f.class) {
                if (eWK == null) {
                    eWK = new f();
                }
            }
        }
        return eWK;
    }

    private f() {
    }

    public boolean uL(String str) {
        return true;
    }

    public boolean uM(String str) {
        return false;
    }
}
