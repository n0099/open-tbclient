package com.baidu.tieba.dnsproxy;
/* loaded from: classes8.dex */
public class f {
    private static f iEE = null;

    public static final f cuh() {
        if (iEE == null) {
            synchronized (f.class) {
                if (iEE == null) {
                    iEE = new f();
                }
            }
        }
        return iEE;
    }

    private f() {
    }

    public boolean IY(String str) {
        return true;
    }

    public boolean IZ(String str) {
        return false;
    }
}
