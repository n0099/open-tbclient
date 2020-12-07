package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f kDo;
    private boolean isAcceptNotify;

    public static f daa() {
        if (kDo == null) {
            synchronized (f.class) {
                if (kDo == null) {
                    kDo = new f();
                }
            }
        }
        return kDo;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
