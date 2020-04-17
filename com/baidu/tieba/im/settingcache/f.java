package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class f {
    private static volatile f ivl;
    private boolean isAcceptNotify;

    public static f ciX() {
        if (ivl == null) {
            synchronized (f.class) {
                if (ivl == null) {
                    ivl = new f();
                }
            }
        }
        return ivl;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
