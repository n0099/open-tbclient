package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f hqZ = null;

    public static final f cdJ() {
        if (hqZ == null) {
            synchronized (f.class) {
                if (hqZ == null) {
                    hqZ = new f();
                }
            }
        }
        return hqZ;
    }

    private f() {
    }

    public boolean Hj(String str) {
        return true;
    }

    public boolean Hk(String str) {
        return false;
    }
}
