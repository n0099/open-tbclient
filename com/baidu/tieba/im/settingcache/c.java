package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dUT;
    private boolean isAcceptNotify;

    public static c aDh() {
        if (dUT == null) {
            synchronized (c.class) {
                if (dUT == null) {
                    dUT = new c();
                }
            }
        }
        return dUT;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
