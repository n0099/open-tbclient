package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c fcG;
    private boolean isAcceptNotify;

    public static c aVw() {
        if (fcG == null) {
            synchronized (c.class) {
                if (fcG == null) {
                    fcG = new c();
                }
            }
        }
        return fcG;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
