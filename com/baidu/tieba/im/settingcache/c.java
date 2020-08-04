package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c jkb;
    private boolean isAcceptNotify;

    public static c cxr() {
        if (jkb == null) {
            synchronized (c.class) {
                if (jkb == null) {
                    jkb = new c();
                }
            }
        }
        return jkb;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
