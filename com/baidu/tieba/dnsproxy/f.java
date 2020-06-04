package com.baidu.tieba.dnsproxy;
/* loaded from: classes6.dex */
public class f {
    private static f gLE = null;

    public static final f bNg() {
        if (gLE == null) {
            synchronized (f.class) {
                if (gLE == null) {
                    gLE = new f();
                }
            }
        }
        return gLE;
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
