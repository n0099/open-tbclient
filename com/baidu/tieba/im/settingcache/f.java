package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dEk;
    private boolean isAcceptNotify;

    public static f azc() {
        if (dEk == null) {
            synchronized (f.class) {
                if (dEk == null) {
                    dEk = new f();
                }
            }
        }
        return dEk;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
