package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f gsG;
    private boolean isAcceptNotify;

    public static f bwb() {
        if (gsG == null) {
            synchronized (f.class) {
                if (gsG == null) {
                    gsG = new f();
                }
            }
        }
        return gsG;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
