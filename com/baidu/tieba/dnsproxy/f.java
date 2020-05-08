package com.baidu.tieba.dnsproxy;
/* loaded from: classes6.dex */
public class f {
    private static f gwJ = null;

    public static final f bGK() {
        if (gwJ == null) {
            synchronized (f.class) {
                if (gwJ == null) {
                    gwJ = new f();
                }
            }
        }
        return gwJ;
    }

    private f() {
    }

    public boolean BP(String str) {
        return true;
    }

    public boolean BQ(String str) {
        return false;
    }
}
