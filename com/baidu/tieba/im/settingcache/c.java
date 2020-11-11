package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c kpb;
    private boolean isAcceptNotify;

    public static c cVf() {
        if (kpb == null) {
            synchronized (c.class) {
                if (kpb == null) {
                    kpb = new c();
                }
            }
        }
        return kpb;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
