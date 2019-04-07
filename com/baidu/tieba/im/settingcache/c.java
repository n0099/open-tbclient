package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gsy;
    private boolean isAcceptNotify;

    public static c bvY() {
        if (gsy == null) {
            synchronized (c.class) {
                if (gsy == null) {
                    gsy = new c();
                }
            }
        }
        return gsy;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
