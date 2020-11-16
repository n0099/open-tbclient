package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kpS;
    private boolean isAcceptNotify;

    public static f cUO() {
        if (kpS == null) {
            synchronized (f.class) {
                if (kpS == null) {
                    kpS = new f();
                }
            }
        }
        return kpS;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
