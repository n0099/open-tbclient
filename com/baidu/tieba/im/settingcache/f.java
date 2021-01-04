package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kIL;
    private boolean isAcceptNotify;

    public static f cZO() {
        if (kIL == null) {
            synchronized (f.class) {
                if (kIL == null) {
                    kIL = new f();
                }
            }
        }
        return kIL;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
