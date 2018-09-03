package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eCa;
    private boolean isAcceptNotify;

    public static f aNu() {
        if (eCa == null) {
            synchronized (f.class) {
                if (eCa == null) {
                    eCa = new f();
                }
            }
        }
        return eCa;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
