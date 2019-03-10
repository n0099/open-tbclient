package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gsM;
    private boolean isAcceptNotify;

    public static c bwc() {
        if (gsM == null) {
            synchronized (c.class) {
                if (gsM == null) {
                    gsM = new c();
                }
            }
        }
        return gsM;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
