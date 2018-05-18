package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f cFZ = null;

    public static final f ajO() {
        if (cFZ == null) {
            synchronized (f.class) {
                if (cFZ == null) {
                    cFZ = new f();
                }
            }
        }
        return cFZ;
    }

    private f() {
    }

    public boolean kR(String str) {
        return true;
    }

    public boolean kS(String str) {
        return false;
    }
}
