package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f dll = null;

    public static final f auc() {
        if (dll == null) {
            synchronized (f.class) {
                if (dll == null) {
                    dll = new f();
                }
            }
        }
        return dll;
    }

    private f() {
    }

    public boolean mW(String str) {
        return true;
    }

    public boolean mX(String str) {
        return false;
    }
}
