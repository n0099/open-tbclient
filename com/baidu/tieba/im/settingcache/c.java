package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c ehU;
    private boolean isAcceptNotify;

    public static c aGV() {
        if (ehU == null) {
            synchronized (c.class) {
                if (ehU == null) {
                    ehU = new c();
                }
            }
        }
        return ehU;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
