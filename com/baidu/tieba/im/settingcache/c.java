package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c jzg;
    private boolean isAcceptNotify;

    public static c cIj() {
        if (jzg == null) {
            synchronized (c.class) {
                if (jzg == null) {
                    jzg = new c();
                }
            }
        }
        return jzg;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
