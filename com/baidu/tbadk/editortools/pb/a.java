package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a csk;
    private int mStatus = 0;

    public static a arp() {
        if (csk == null) {
            synchronized (a.class) {
                if (csk == null) {
                    csk = new a();
                }
            }
        }
        return csk;
    }

    private a() {
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }
}
