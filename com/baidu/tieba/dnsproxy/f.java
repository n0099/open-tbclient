package com.baidu.tieba.dnsproxy;
/* loaded from: classes3.dex */
public class f {
    private static f deE = null;

    public static final f asq() {
        if (deE == null) {
            synchronized (f.class) {
                if (deE == null) {
                    deE = new f();
                }
            }
        }
        return deE;
    }

    private f() {
    }

    public boolean mx(String str) {
        return true;
    }

    public boolean my(String str) {
        return false;
    }
}
