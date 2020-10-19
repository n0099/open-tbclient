package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f hNf = null;

    public static final f ckv() {
        if (hNf == null) {
            synchronized (f.class) {
                if (hNf == null) {
                    hNf = new f();
                }
            }
        }
        return hNf;
    }

    private f() {
    }

    public boolean Iu(String str) {
        return true;
    }

    public boolean Iv(String str) {
        return false;
    }
}
