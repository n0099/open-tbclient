package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dVa;
    private boolean isAcceptNotify;

    public static f aDk() {
        if (dVa == null) {
            synchronized (f.class) {
                if (dVa == null) {
                    dVa = new f();
                }
            }
        }
        return dVa;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
