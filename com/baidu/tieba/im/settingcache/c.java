package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c gsz;
    private boolean isAcceptNotify;

    public static c bvY() {
        if (gsz == null) {
            synchronized (c.class) {
                if (gsz == null) {
                    gsz = new c();
                }
            }
        }
        return gsz;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
