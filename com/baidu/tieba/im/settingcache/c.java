package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eBT;
    private boolean isAcceptNotify;

    public static c aNr() {
        if (eBT == null) {
            synchronized (c.class) {
                if (eBT == null) {
                    eBT = new c();
                }
            }
        }
        return eBT;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
