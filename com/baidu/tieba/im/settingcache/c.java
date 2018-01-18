package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eIA;
    private boolean isAcceptNotify;

    public static c aKo() {
        if (eIA == null) {
            synchronized (c.class) {
                if (eIA == null) {
                    eIA = new c();
                }
            }
        }
        return eIA;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
