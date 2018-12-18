package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eZb;
    private boolean isAcceptNotify;

    public static c aUi() {
        if (eZb == null) {
            synchronized (c.class) {
                if (eZb == null) {
                    eZb = new c();
                }
            }
        }
        return eZb;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
