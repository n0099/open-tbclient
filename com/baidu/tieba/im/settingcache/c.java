package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eNo;
    private boolean isAcceptNotify;

    public static c aLV() {
        if (eNo == null) {
            synchronized (c.class) {
                if (eNo == null) {
                    eNo = new c();
                }
            }
        }
        return eNo;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
