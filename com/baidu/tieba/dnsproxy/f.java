package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f dmK = null;

    public static final f apF() {
        if (dmK == null) {
            synchronized (f.class) {
                if (dmK == null) {
                    dmK = new f();
                }
            }
        }
        return dmK;
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
