package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f igs = null;

    public static final f cpG() {
        if (igs == null) {
            synchronized (f.class) {
                if (igs == null) {
                    igs = new f();
                }
            }
        }
        return igs;
    }

    private f() {
    }

    public boolean IL(String str) {
        return true;
    }

    public boolean IM(String str) {
        return false;
    }
}
