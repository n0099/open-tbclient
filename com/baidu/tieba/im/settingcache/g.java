package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g dmx;
    private boolean isAcceptNotify;

    public static g awH() {
        if (dmx == null) {
            synchronized (g.class) {
                if (dmx == null) {
                    dmx = new g();
                }
            }
        }
        return dmx;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
