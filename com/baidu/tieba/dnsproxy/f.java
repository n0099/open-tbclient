package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eUL = null;

    public static final f beW() {
        if (eUL == null) {
            synchronized (f.class) {
                if (eUL == null) {
                    eUL = new f();
                }
            }
        }
        return eUL;
    }

    private f() {
    }

    public boolean wn(String str) {
        return true;
    }

    public boolean wo(String str) {
        return false;
    }
}
