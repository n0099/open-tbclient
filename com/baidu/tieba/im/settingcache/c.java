package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gQL;
    private boolean isAcceptNotify;

    public static c bEe() {
        if (gQL == null) {
            synchronized (c.class) {
                if (gQL == null) {
                    gQL = new c();
                }
            }
        }
        return gQL;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
