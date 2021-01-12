package com.baidu.tieba.dnsproxy;
/* loaded from: classes7.dex */
public class f {
    private static f iyU = null;

    public static final f csV() {
        if (iyU == null) {
            synchronized (f.class) {
                if (iyU == null) {
                    iyU = new f();
                }
            }
        }
        return iyU;
    }

    private f() {
    }

    public boolean In(String str) {
        return true;
    }

    public boolean Io(String str) {
        return false;
    }
}
