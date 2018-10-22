package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f ddy = null;

    public static final f asR() {
        if (ddy == null) {
            synchronized (f.class) {
                if (ddy == null) {
                    ddy = new f();
                }
            }
        }
        return ddy;
    }

    private f() {
    }

    public boolean mw(String str) {
        return true;
    }

    public boolean mx(String str) {
        return false;
    }
}
