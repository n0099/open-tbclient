package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gsL;
    private boolean isAcceptNotify;

    public static c bwb() {
        if (gsL == null) {
            synchronized (c.class) {
                if (gsL == null) {
                    gsL = new c();
                }
            }
        }
        return gsL;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
