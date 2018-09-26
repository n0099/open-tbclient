package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eJr;
    private boolean isAcceptNotify;

    public static f aPJ() {
        if (eJr == null) {
            synchronized (f.class) {
                if (eJr == null) {
                    eJr = new f();
                }
            }
        }
        return eJr;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
