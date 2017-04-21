package com.baidu.tieba.im.settingcache;
/* loaded from: classes.dex */
public class g {
    private static volatile g dht;
    private boolean isAcceptNotify;

    public static g auy() {
        if (dht == null) {
            synchronized (g.class) {
                if (dht == null) {
                    dht = new g();
                }
            }
        }
        return dht;
    }

    public boolean isAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }
}
