package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dEy;
    private boolean isAcceptNotify;

    public static f azh() {
        if (dEy == null) {
            synchronized (f.class) {
                if (dEy == null) {
                    dEy = new f();
                }
            }
        }
        return dEy;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
