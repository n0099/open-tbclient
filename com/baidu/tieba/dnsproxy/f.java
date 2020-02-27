package com.baidu.tieba.dnsproxy;
/* loaded from: classes6.dex */
public class f {
    private static f fQX = null;

    public static final f bwS() {
        if (fQX == null) {
            synchronized (f.class) {
                if (fQX == null) {
                    fQX = new f();
                }
            }
        }
        return fQX;
    }

    private f() {
    }

    public boolean Ad(String str) {
        return true;
    }

    public boolean Ae(String str) {
        return false;
    }
}
