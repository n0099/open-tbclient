package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f dmN = null;

    public static final f apG() {
        if (dmN == null) {
            synchronized (f.class) {
                if (dmN == null) {
                    dmN = new f();
                }
            }
        }
        return dmN;
    }

    private f() {
    }

    public boolean kL(String str) {
        return true;
    }

    public boolean kM(String str) {
        return false;
    }
}
