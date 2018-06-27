package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f cMJ = null;

    public static final f anf() {
        if (cMJ == null) {
            synchronized (f.class) {
                if (cMJ == null) {
                    cMJ = new f();
                }
            }
        }
        return cMJ;
    }

    private f() {
    }

    public boolean lr(String str) {
        return true;
    }

    public boolean ls(String str) {
        return false;
    }
}
