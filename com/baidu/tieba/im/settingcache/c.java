package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eSm;
    private boolean isAcceptNotify;

    public static c aSr() {
        if (eSm == null) {
            synchronized (c.class) {
                if (eSm == null) {
                    eSm = new c();
                }
            }
        }
        return eSm;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
