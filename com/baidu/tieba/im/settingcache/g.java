package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g dbu;
    private boolean isAcceptNotify;

    public static g ars() {
        if (dbu == null) {
            synchronized (g.class) {
                if (dbu == null) {
                    dbu = new g();
                }
            }
        }
        return dbu;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
