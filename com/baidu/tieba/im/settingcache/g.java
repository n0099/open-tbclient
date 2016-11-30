package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g dsg;
    private boolean isAcceptNotify;

    public static g ayE() {
        if (dsg == null) {
            synchronized (g.class) {
                if (dsg == null) {
                    dsg = new g();
                }
            }
        }
        return dsg;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
