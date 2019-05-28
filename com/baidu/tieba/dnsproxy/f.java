package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eNY = null;

    public static final f bcp() {
        if (eNY == null) {
            synchronized (f.class) {
                if (eNY == null) {
                    eNY = new f();
                }
            }
        }
        return eNY;
    }

    private f() {
    }

    public boolean vj(String str) {
        return true;
    }

    public boolean vk(String str) {
        return false;
    }
}
