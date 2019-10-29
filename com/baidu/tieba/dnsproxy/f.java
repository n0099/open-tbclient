package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eXB = null;

    public static final f bcR() {
        if (eXB == null) {
            synchronized (f.class) {
                if (eXB == null) {
                    eXB = new f();
                }
            }
        }
        return eXB;
    }

    private f() {
    }

    public boolean uL(String str) {
        return true;
    }

    public boolean uM(String str) {
        return false;
    }
}
