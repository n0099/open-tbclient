package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dxp;
    private boolean isAcceptNotify;

    public static c axE() {
        if (dxp == null) {
            synchronized (c.class) {
                if (dxp == null) {
                    dxp = new c();
                }
            }
        }
        return dxp;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
