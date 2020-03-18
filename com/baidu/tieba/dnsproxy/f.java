package com.baidu.tieba.dnsproxy;
/* loaded from: classes6.dex */
public class f {
    private static f fRV = null;

    public static final f bxa() {
        if (fRV == null) {
            synchronized (f.class) {
                if (fRV == null) {
                    fRV = new f();
                }
            }
        }
        return fRV;
    }

    private f() {
    }

    public boolean Af(String str) {
        return true;
    }

    public boolean Ag(String str) {
        return false;
    }
}
