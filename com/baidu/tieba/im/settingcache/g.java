package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g bDJ;
    private boolean isAcceptNotify;

    public static g Ww() {
        if (bDJ == null) {
            synchronized (g.class) {
                if (bDJ == null) {
                    bDJ = new g();
                }
            }
        }
        return bDJ;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
