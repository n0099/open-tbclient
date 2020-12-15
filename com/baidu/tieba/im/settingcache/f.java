package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kDq;
    private boolean isAcceptNotify;

    public static f dab() {
        if (kDq == null) {
            synchronized (f.class) {
                if (kDq == null) {
                    kDq = new f();
                }
            }
        }
        return kDq;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
