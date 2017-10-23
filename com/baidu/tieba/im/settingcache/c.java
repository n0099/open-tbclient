package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dEd;
    private boolean isAcceptNotify;

    public static c ayZ() {
        if (dEd == null) {
            synchronized (c.class) {
                if (dEd == null) {
                    dEd = new c();
                }
            }
        }
        return dEd;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
