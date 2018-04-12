package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f eib;
    private boolean isAcceptNotify;

    public static f aGY() {
        if (eib == null) {
            synchronized (f.class) {
                if (eib == null) {
                    eib = new f();
                }
            }
        }
        return eib;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
