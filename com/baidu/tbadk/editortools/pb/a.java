package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a fEY;
    private int mStatus = 0;

    public static a bBN() {
        if (fEY == null) {
            synchronized (a.class) {
                if (fEY == null) {
                    fEY = new a();
                }
            }
        }
        return fEY;
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
