package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a bub;
    private int mStatus = 0;

    public static a Ly() {
        if (bub == null) {
            synchronized (a.class) {
                if (bub == null) {
                    bub = new a();
                }
            }
        }
        return bub;
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
