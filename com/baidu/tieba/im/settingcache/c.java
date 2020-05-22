package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c iJQ;
    private boolean isAcceptNotify;

    public static c cpq() {
        if (iJQ == null) {
            synchronized (c.class) {
                if (iJQ == null) {
                    iJQ = new c();
                }
            }
        }
        return iJQ;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
