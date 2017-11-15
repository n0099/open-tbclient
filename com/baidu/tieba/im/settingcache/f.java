package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dMd;
    private boolean isAcceptNotify;

    public static f aBB() {
        if (dMd == null) {
            synchronized (f.class) {
                if (dMd == null) {
                    dMd = new f();
                }
            }
        }
        return dMd;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
