package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f cPp = null;

    public static final f anG() {
        if (cPp == null) {
            synchronized (f.class) {
                if (cPp == null) {
                    cPp = new f();
                }
            }
        }
        return cPp;
    }

    private f() {
    }

    public boolean ls(String str) {
        return true;
    }

    public boolean lt(String str) {
        return false;
    }
}
