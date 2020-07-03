package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c jbF;
    private boolean isAcceptNotify;

    public static c cto() {
        if (jbF == null) {
            synchronized (c.class) {
                if (jbF == null) {
                    jbF = new c();
                }
            }
        }
        return jbF;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
