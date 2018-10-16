package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aVy;
    private int mStatus = 0;

    public static a Ld() {
        if (aVy == null) {
            synchronized (a.class) {
                if (aVy == null) {
                    aVy = new a();
                }
            }
        }
        return aVy;
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
