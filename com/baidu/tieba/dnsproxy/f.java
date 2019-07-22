package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eSY = null;

    public static final f beq() {
        if (eSY == null) {
            synchronized (f.class) {
                if (eSY == null) {
                    eSY = new f();
                }
            }
        }
        return eSY;
    }

    private f() {
    }

    public boolean vN(String str) {
        return true;
    }

    public boolean vO(String str) {
        return false;
    }
}
