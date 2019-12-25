package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c hDY;
    private boolean isAcceptNotify;

    public static c bVo() {
        if (hDY == null) {
            synchronized (c.class) {
                if (hDY == null) {
                    hDY = new c();
                }
            }
        }
        return hDY;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
