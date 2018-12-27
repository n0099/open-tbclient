package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class c {
    private static volatile c fbS;
    private boolean isAcceptNotify;

    public static c aUW() {
        if (fbS == null) {
            synchronized (c.class) {
                if (fbS == null) {
                    fbS = new c();
                }
            }
        }
        return fbS;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
