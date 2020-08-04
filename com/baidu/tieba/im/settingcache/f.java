package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f jki;
    private boolean isAcceptNotify;

    public static f cxu() {
        if (jki == null) {
            synchronized (f.class) {
                if (jki == null) {
                    jki = new f();
                }
            }
        }
        return jki;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
