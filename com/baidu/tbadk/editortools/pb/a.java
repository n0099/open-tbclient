package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a fBk;
    private int mStatus = 0;

    public static a bBs() {
        if (fBk == null) {
            synchronized (a.class) {
                if (fBk == null) {
                    fBk = new a();
                }
            }
        }
        return fBk;
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
