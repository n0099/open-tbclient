package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c eyf;
    private boolean isAcceptNotify;

    public static c aMu() {
        if (eyf == null) {
            synchronized (c.class) {
                if (eyf == null) {
                    eyf = new c();
                }
            }
        }
        return eyf;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
