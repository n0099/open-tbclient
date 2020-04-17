package com.baidu.tieba.dnsproxy;
/* loaded from: classes6.dex */
public class f {
    private static f gwD = null;

    public static final f bGM() {
        if (gwD == null) {
            synchronized (f.class) {
                if (gwD == null) {
                    gwD = new f();
                }
            }
        }
        return gwD;
    }

    private f() {
    }

    public boolean BM(String str) {
        return true;
    }

    public boolean BN(String str) {
        return false;
    }
}
