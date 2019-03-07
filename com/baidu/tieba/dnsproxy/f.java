package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eyN = null;

    public static final f aVg() {
        if (eyN == null) {
            synchronized (f.class) {
                if (eyN == null) {
                    eyN = new f();
                }
            }
        }
        return eyN;
    }

    private f() {
    }

    public boolean tR(String str) {
        return true;
    }

    public boolean tS(String str) {
        return false;
    }
}
