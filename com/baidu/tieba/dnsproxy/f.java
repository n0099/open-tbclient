package com.baidu.tieba.dnsproxy;
/* loaded from: classes6.dex */
public class f {
    private static f fRm = null;

    public static final f bwV() {
        if (fRm == null) {
            synchronized (f.class) {
                if (fRm == null) {
                    fRm = new f();
                }
            }
        }
        return fRm;
    }

    private f() {
    }

    public boolean Ae(String str) {
        return true;
    }

    public boolean Af(String str) {
        return false;
    }
}
