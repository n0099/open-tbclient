package com.baidu.tieba.dnsproxy;
/* loaded from: classes5.dex */
public class f {
    private static f fOC = null;

    public static final f bvo() {
        if (fOC == null) {
            synchronized (f.class) {
                if (fOC == null) {
                    fOC = new f();
                }
            }
        }
        return fOC;
    }

    private f() {
    }

    public boolean zN(String str) {
        return true;
    }

    public boolean zO(String str) {
        return false;
    }
}
