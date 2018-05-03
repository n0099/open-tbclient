package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f cEQ = null;

    public static final f ajO() {
        if (cEQ == null) {
            synchronized (f.class) {
                if (cEQ == null) {
                    cEQ = new f();
                }
            }
        }
        return cEQ;
    }

    private f() {
    }

    public boolean kO(String str) {
        return true;
    }

    public boolean kP(String str) {
        return false;
    }
}
