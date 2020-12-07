package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f irm = null;

    public static final f ctU() {
        if (irm == null) {
            synchronized (f.class) {
                if (irm == null) {
                    irm = new f();
                }
            }
        }
        return irm;
    }

    private f() {
    }

    public boolean JB(String str) {
        return true;
    }

    public boolean JC(String str) {
        return false;
    }
}
