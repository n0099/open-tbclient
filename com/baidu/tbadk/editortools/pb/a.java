package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aDy;
    private int mStatus = 0;

    public static a Dz() {
        if (aDy == null) {
            synchronized (a.class) {
                if (aDy == null) {
                    aDy = new a();
                }
            }
        }
        return aDy;
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
