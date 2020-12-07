package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kDh;
    private boolean isAcceptNotify;

    public static c cZX() {
        if (kDh == null) {
            synchronized (c.class) {
                if (kDh == null) {
                    kDh = new c();
                }
            }
        }
        return kDh;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
