package com.baidu.tieba.dnsproxy;
/* loaded from: classes6.dex */
public class f {
    private static f gYB = null;

    public static final f bQl() {
        if (gYB == null) {
            synchronized (f.class) {
                if (gYB == null) {
                    gYB = new f();
                }
            }
        }
        return gYB;
    }

    private f() {
    }

    public boolean DZ(String str) {
        return true;
    }

    public boolean Ea(String str) {
        return false;
    }
}
