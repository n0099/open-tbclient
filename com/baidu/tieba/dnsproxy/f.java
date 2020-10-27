package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f hZC = null;

    public static final f cnC() {
        if (hZC == null) {
            synchronized (f.class) {
                if (hZC == null) {
                    hZC = new f();
                }
            }
        }
        return hZC;
    }

    private f() {
    }

    public boolean IT(String str) {
        return true;
    }

    public boolean IU(String str) {
        return false;
    }
}
