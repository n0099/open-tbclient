package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kMz;
    private boolean isAcceptNotify;

    public static f cYc() {
        if (kMz == null) {
            synchronized (f.class) {
                if (kMz == null) {
                    kMz = new f();
                }
            }
        }
        return kMz;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
