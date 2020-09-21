package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f hyk = null;

    public static final f cgZ() {
        if (hyk == null) {
            synchronized (f.class) {
                if (hyk == null) {
                    hyk = new f();
                }
            }
        }
        return hyk;
    }

    private f() {
    }

    public boolean HH(String str) {
        return true;
    }

    public boolean HI(String str) {
        return false;
    }
}
