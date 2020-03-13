package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c hJO;
    private boolean isAcceptNotify;

    public static c bYb() {
        if (hJO == null) {
            synchronized (c.class) {
                if (hJO == null) {
                    hJO = new c();
                }
            }
        }
        return hJO;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
