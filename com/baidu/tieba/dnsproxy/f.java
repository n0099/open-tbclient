package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f dmW = null;

    public static final f apG() {
        if (dmW == null) {
            synchronized (f.class) {
                if (dmW == null) {
                    dmW = new f();
                }
            }
        }
        return dmW;
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
