package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aCY;
    private int mStatus = 0;

    public static a Dp() {
        if (aCY == null) {
            synchronized (a.class) {
                if (aCY == null) {
                    aCY = new a();
                }
            }
        }
        return aCY;
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
