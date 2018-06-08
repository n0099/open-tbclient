package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f euw;
    private boolean isAcceptNotify;

    public static f aLR() {
        if (euw == null) {
            synchronized (f.class) {
                if (euw == null) {
                    euw = new f();
                }
            }
        }
        return euw;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
