package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c dyH;
    private boolean isAcceptNotify;

    public static c axP() {
        if (dyH == null) {
            synchronized (c.class) {
                if (dyH == null) {
                    dyH = new c();
                }
            }
        }
        return dyH;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
