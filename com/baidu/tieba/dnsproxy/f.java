package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eNX = null;

    public static final f bcm() {
        if (eNX == null) {
            synchronized (f.class) {
                if (eNX == null) {
                    eNX = new f();
                }
            }
        }
        return eNX;
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
