package com.baidu.tieba.dnsproxy;
/* loaded from: classes7.dex */
public class f {
    private static f iGB = null;

    public static final f cuu() {
        if (iGB == null) {
            synchronized (f.class) {
                if (iGB == null) {
                    iGB = new f();
                }
            }
        }
        return iGB;
    }

    private f() {
    }

    public boolean Ji(String str) {
        return true;
    }

    public boolean Jj(String str) {
        return false;
    }
}
