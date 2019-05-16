package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gJM;
    private boolean isAcceptNotify;

    public static c bDG() {
        if (gJM == null) {
            synchronized (c.class) {
                if (gJM == null) {
                    gJM = new c();
                }
            }
        }
        return gJM;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
