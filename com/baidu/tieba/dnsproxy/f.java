package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f dod = null;

    public static final f auR() {
        if (dod == null) {
            synchronized (f.class) {
                if (dod == null) {
                    dod = new f();
                }
            }
        }
        return dod;
    }

    private f() {
    }

    public boolean mZ(String str) {
        return true;
    }

    public boolean na(String str) {
        return false;
    }
}
