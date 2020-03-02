package com.baidu.tieba.dnsproxy;
/* loaded from: classes6.dex */
public class f {
    private static f fQZ = null;

    public static final f bwU() {
        if (fQZ == null) {
            synchronized (f.class) {
                if (fQZ == null) {
                    fQZ = new f();
                }
            }
        }
        return fQZ;
    }

    private f() {
    }

    public boolean Ad(String str) {
        return true;
    }

    public boolean Ae(String str) {
        return false;
    }
}
