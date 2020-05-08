package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a dYq;
    private int mStatus = 0;

    public static a aXj() {
        if (dYq == null) {
            synchronized (a.class) {
                if (dYq == null) {
                    dYq = new a();
                }
            }
        }
        return dYq;
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
