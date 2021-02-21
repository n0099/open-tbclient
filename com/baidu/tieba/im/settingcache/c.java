package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kMs;
    private boolean isAcceptNotify;

    public static c cXZ() {
        if (kMs == null) {
            synchronized (c.class) {
                if (kMs == null) {
                    kMs = new c();
                }
            }
        }
        return kMs;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
