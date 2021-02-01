package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kMe;
    private boolean isAcceptNotify;

    public static c cXS() {
        if (kMe == null) {
            synchronized (c.class) {
                if (kMe == null) {
                    kMe = new c();
                }
            }
        }
        return kMe;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
