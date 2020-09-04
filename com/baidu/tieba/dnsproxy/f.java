package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f hrf = null;

    public static final f cdK() {
        if (hrf == null) {
            synchronized (f.class) {
                if (hrf == null) {
                    hrf = new f();
                }
            }
        }
        return hrf;
    }

    private f() {
    }

    public boolean Hk(String str) {
        return true;
    }

    public boolean Hl(String str) {
        return false;
    }
}
