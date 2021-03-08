package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kOu;
    private boolean isAcceptNotify;

    public static c cYg() {
        if (kOu == null) {
            synchronized (c.class) {
                if (kOu == null) {
                    kOu = new c();
                }
            }
        }
        return kOu;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
