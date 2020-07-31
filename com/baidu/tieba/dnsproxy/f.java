package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f heg = null;

    public static final f bTx() {
        if (heg == null) {
            synchronized (f.class) {
                if (heg == null) {
                    heg = new f();
                }
            }
        }
        return heg;
    }

    private f() {
    }

    public boolean EK(String str) {
        return true;
    }

    public boolean EL(String str) {
        return false;
    }
}
