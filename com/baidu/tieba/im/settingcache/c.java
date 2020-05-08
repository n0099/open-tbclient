package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c ivk;
    private boolean isAcceptNotify;

    public static c ciS() {
        if (ivk == null) {
            synchronized (c.class) {
                if (ivk == null) {
                    ivk = new c();
                }
            }
        }
        return ivk;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
