package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f ivr;
    private boolean isAcceptNotify;

    public static f ciW() {
        if (ivr == null) {
            synchronized (f.class) {
                if (ivr == null) {
                    ivr = new f();
                }
            }
        }
        return ivr;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
