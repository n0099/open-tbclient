package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f fcM;
    private boolean isAcceptNotify;

    public static f aVz() {
        if (fcM == null) {
            synchronized (f.class) {
                if (fcM == null) {
                    fcM = new f();
                }
            }
        }
        return fcM;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
