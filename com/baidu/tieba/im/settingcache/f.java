package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kEg;
    private boolean isAcceptNotify;

    public static f cVX() {
        if (kEg == null) {
            synchronized (f.class) {
                if (kEg == null) {
                    kEg = new f();
                }
            }
        }
        return kEg;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
