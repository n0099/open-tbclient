package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eyv = null;

    public static final f aVe() {
        if (eyv == null) {
            synchronized (f.class) {
                if (eyv == null) {
                    eyv = new f();
                }
            }
        }
        return eyv;
    }

    private f() {
    }

    public boolean tP(String str) {
        return true;
    }

    public boolean tQ(String str) {
        return false;
    }
}
