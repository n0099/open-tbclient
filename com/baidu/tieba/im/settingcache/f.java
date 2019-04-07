package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gsF;
    private boolean isAcceptNotify;

    public static f bwb() {
        if (gsF == null) {
            synchronized (f.class) {
                if (gsF == null) {
                    gsF = new f();
                }
            }
        }
        return gsF;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
