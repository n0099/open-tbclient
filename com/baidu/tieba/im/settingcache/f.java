package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f ejf;
    private boolean isAcceptNotify;

    public static f aGW() {
        if (ejf == null) {
            synchronized (f.class) {
                if (ejf == null) {
                    ejf = new f();
                }
            }
        }
        return ejf;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
