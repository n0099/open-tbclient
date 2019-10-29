package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gQS;
    private boolean isAcceptNotify;

    public static f bEh() {
        if (gQS == null) {
            synchronized (f.class) {
                if (gQS == null) {
                    gQS = new f();
                }
            }
        }
        return gQS;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
