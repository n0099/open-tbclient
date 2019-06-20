package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gJP;
    private boolean isAcceptNotify;

    public static c bDK() {
        if (gJP == null) {
            synchronized (c.class) {
                if (gJP == null) {
                    gJP = new c();
                }
            }
        }
        return gJP;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
