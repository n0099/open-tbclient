package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c hHB;
    private boolean isAcceptNotify;

    public static c bWx() {
        if (hHB == null) {
            synchronized (c.class) {
                if (hHB == null) {
                    hHB = new c();
                }
            }
        }
        return hHB;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
