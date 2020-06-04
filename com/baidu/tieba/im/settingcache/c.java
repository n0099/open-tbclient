package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c iKD;
    private boolean isAcceptNotify;

    public static c cpz() {
        if (iKD == null) {
            synchronized (c.class) {
                if (iKD == null) {
                    iKD = new c();
                }
            }
        }
        return iKD;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
