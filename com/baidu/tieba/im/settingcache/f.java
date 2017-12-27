package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eHh;
    private boolean isAcceptNotify;

    public static f aKm() {
        if (eHh == null) {
            synchronized (f.class) {
                if (eHh == null) {
                    eHh = new f();
                }
            }
        }
        return eHh;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
