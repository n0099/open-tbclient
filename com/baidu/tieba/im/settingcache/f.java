package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f hLv;
    private boolean isAcceptNotify;

    public static f bYw() {
        if (hLv == null) {
            synchronized (f.class) {
                if (hLv == null) {
                    hLv = new f();
                }
            }
        }
        return hLv;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
