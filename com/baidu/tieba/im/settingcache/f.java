package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dUW;
    private boolean isAcceptNotify;

    public static f aDk() {
        if (dUW == null) {
            synchronized (f.class) {
                if (dUW == null) {
                    dUW = new f();
                }
            }
        }
        return dUW;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
