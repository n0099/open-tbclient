package com.baidu.tieba.dnsproxy;
/* loaded from: classes2.dex */
public class f {
    private static f eyu = null;

    public static final f aVe() {
        if (eyu == null) {
            synchronized (f.class) {
                if (eyu == null) {
                    eyu = new f();
                }
            }
        }
        return eyu;
    }

    private f() {
    }

    public boolean tP(String str) {
        return true;
    }

    public boolean tQ(String str) {
        return false;
    }
}
