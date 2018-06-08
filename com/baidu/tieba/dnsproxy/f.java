package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f cOP = null;

    public static final f anL() {
        if (cOP == null) {
            synchronized (f.class) {
                if (cOP == null) {
                    cOP = new f();
                }
            }
        }
        return cOP;
    }

    private f() {
    }

    public boolean lu(String str) {
        return true;
    }

    public boolean lv(String str) {
        return false;
    }
}
