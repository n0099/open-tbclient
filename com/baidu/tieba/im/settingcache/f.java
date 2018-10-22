package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eRb;
    private boolean isAcceptNotify;

    public static f aSX() {
        if (eRb == null) {
            synchronized (f.class) {
                if (eRb == null) {
                    eRb = new f();
                }
            }
        }
        return eRb;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
