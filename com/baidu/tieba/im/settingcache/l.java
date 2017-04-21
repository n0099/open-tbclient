package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class l {
    private static volatile l dhA;
    private boolean isAcceptNotify;

    public static l auB() {
        if (dhA == null) {
            synchronized (l.class) {
                if (dhA == null) {
                    dhA = new l();
                }
            }
        }
        return dhA;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
