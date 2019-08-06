package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eTf = null;

    public static final f bes() {
        if (eTf == null) {
            synchronized (f.class) {
                if (eTf == null) {
                    eTf = new f();
                }
            }
        }
        return eTf;
    }

    private f() {
    }

    public boolean vO(String str) {
        return true;
    }

    public boolean vP(String str) {
        return false;
    }
}
