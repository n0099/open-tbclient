package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gQb;
    private boolean isAcceptNotify;

    public static f bEf() {
        if (gQb == null) {
            synchronized (f.class) {
                if (gQb == null) {
                    gQb = new f();
                }
            }
        }
        return gQb;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
