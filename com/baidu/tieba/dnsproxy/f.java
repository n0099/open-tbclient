package com.baidu.tieba.dnsproxy;
/* loaded from: classes6.dex */
public class f {
    private static f gLt = null;

    public static final f bNe() {
        if (gLt == null) {
            synchronized (f.class) {
                if (gLt == null) {
                    gLt = new f();
                }
            }
        }
        return gLt;
    }

    private f() {
    }

    public boolean Dy(String str) {
        return true;
    }

    public boolean Dz(String str) {
        return false;
    }
}
