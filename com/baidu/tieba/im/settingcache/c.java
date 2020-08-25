package com.baidu.tieba.im.settingcache;
/* loaded from: classes2.dex */
public class c {
    private static volatile c jza;
    private boolean isAcceptNotify;

    public static c cIi() {
        if (jza == null) {
            synchronized (c.class) {
                if (jza == null) {
                    jza = new c();
                }
            }
        }
        return jza;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
