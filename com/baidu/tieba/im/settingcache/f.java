package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eRa;
    private boolean isAcceptNotify;

    public static f aSX() {
        if (eRa == null) {
            synchronized (f.class) {
                if (eRa == null) {
                    eRa = new f();
                }
            }
        }
        return eRa;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
