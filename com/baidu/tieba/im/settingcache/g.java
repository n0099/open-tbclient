package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g dla;
    private boolean isAcceptNotify;

    public static g awi() {
        if (dla == null) {
            synchronized (g.class) {
                if (dla == null) {
                    dla = new g();
                }
            }
        }
        return dla;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
