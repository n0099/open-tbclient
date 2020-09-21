package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c jHI;
    private boolean isAcceptNotify;

    public static c cLP() {
        if (jHI == null) {
            synchronized (c.class) {
                if (jHI == null) {
                    jHI = new c();
                }
            }
        }
        return jHI;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
