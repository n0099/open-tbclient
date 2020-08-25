package com.baidu.tieba.im.settingcache;
/* loaded from: classes2.dex */
public class f {
    private static volatile f jzh;
    private boolean isAcceptNotify;

    public static f cIl() {
        if (jzh == null) {
            synchronized (f.class) {
                if (jzh == null) {
                    jzh = new f();
                }
            }
        }
        return jzh;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
