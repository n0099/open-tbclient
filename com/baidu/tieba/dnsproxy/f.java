package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eyJ = null;

    public static final f aVg() {
        if (eyJ == null) {
            synchronized (f.class) {
                if (eyJ == null) {
                    eyJ = new f();
                }
            }
        }
        return eyJ;
    }

    private f() {
    }

    public boolean tQ(String str) {
        return true;
    }

    public boolean tR(String str) {
        return false;
    }
}
