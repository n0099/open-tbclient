package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dHh;
    private boolean isAcceptNotify;

    public static c aAg() {
        if (dHh == null) {
            synchronized (c.class) {
                if (dHh == null) {
                    dHh = new c();
                }
            }
        }
        return dHh;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
