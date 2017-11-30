package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f dTR;
    private boolean isAcceptNotify;

    public static f aDb() {
        if (dTR == null) {
            synchronized (f.class) {
                if (dTR == null) {
                    dTR = new f();
                }
            }
        }
        return dTR;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
