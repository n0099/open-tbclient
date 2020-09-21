package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f jHP;
    private boolean isAcceptNotify;

    public static f cLS() {
        if (jHP == null) {
            synchronized (f.class) {
                if (jHP == null) {
                    jHP = new f();
                }
            }
        }
        return jHP;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
