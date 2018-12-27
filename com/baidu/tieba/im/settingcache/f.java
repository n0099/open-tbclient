package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f fbZ;
    private boolean isAcceptNotify;

    public static f aUZ() {
        if (fbZ == null) {
            synchronized (f.class) {
                if (fbZ == null) {
                    fbZ = new f();
                }
            }
        }
        return fbZ;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
