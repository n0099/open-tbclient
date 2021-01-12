package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kDZ;
    private boolean isAcceptNotify;

    public static c cVU() {
        if (kDZ == null) {
            synchronized (c.class) {
                if (kDZ == null) {
                    kDZ = new c();
                }
            }
        }
        return kDZ;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
