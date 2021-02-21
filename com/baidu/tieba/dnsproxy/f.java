package com.baidu.tieba.dnsproxy;
/* loaded from: classes8.dex */
public class f {
    private static f iES = null;

    public static final f cuo() {
        if (iES == null) {
            synchronized (f.class) {
                if (iES == null) {
                    iES = new f();
                }
            }
        }
        return iES;
    }

    private f() {
    }

    public boolean IZ(String str) {
        return true;
    }

    public boolean Ja(String str) {
        return false;
    }
}
