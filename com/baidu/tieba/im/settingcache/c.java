package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kIE;
    private boolean isAcceptNotify;

    public static c cZL() {
        if (kIE == null) {
            synchronized (c.class) {
                if (kIE == null) {
                    kIE = new c();
                }
            }
        }
        return kIE;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
