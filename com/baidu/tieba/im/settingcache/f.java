package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kMl;
    private boolean isAcceptNotify;

    public static f cXV() {
        if (kMl == null) {
            synchronized (f.class) {
                if (kMl == null) {
                    kMl = new f();
                }
            }
        }
        return kMl;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
