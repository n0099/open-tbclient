package com.baidu.tieba.dnsproxy;
/* loaded from: classes4.dex */
public class f {
    private static f fLt = null;

    public static final f bum() {
        if (fLt == null) {
            synchronized (f.class) {
                if (fLt == null) {
                    fLt = new f();
                }
            }
        }
        return fLt;
    }

    private f() {
    }

    public boolean zD(String str) {
        return true;
    }

    public boolean zE(String str) {
        return false;
    }
}
