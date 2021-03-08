package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kOB;
    private boolean isAcceptNotify;

    public static f cYj() {
        if (kOB == null) {
            synchronized (f.class) {
                if (kOB == null) {
                    kOB = new f();
                }
            }
        }
        return kOB;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
