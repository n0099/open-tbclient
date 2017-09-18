package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dIc;
    private boolean isAcceptNotify;

    public static c aAr() {
        if (dIc == null) {
            synchronized (c.class) {
                if (dIc == null) {
                    dIc = new c();
                }
            }
        }
        return dIc;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
