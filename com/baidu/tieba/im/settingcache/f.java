package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eCe;
    private boolean isAcceptNotify;

    public static f aNx() {
        if (eCe == null) {
            synchronized (f.class) {
                if (eCe == null) {
                    eCe = new f();
                }
            }
        }
        return eCe;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
