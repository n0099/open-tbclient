package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f cET = null;

    public static final f ajO() {
        if (cET == null) {
            synchronized (f.class) {
                if (cET == null) {
                    cET = new f();
                }
            }
        }
        return cET;
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
