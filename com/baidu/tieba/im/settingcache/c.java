package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eNk;
    private boolean isAcceptNotify;

    public static c aLV() {
        if (eNk == null) {
            synchronized (c.class) {
                if (eNk == null) {
                    eNk = new c();
                }
            }
        }
        return eNk;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
