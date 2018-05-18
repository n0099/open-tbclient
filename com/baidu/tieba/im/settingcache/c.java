package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eiY;
    private boolean isAcceptNotify;

    public static c aGT() {
        if (eiY == null) {
            synchronized (c.class) {
                if (eiY == null) {
                    eiY = new c();
                }
            }
        }
        return eiY;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
