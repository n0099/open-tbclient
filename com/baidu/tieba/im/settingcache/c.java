package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kDj;
    private boolean isAcceptNotify;

    public static c cZY() {
        if (kDj == null) {
            synchronized (c.class) {
                if (kDj == null) {
                    kDj = new c();
                }
            }
        }
        return kDj;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
