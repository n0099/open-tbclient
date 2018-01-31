package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a brN;
    private int mStatus = 0;

    public static a KR() {
        if (brN == null) {
            synchronized (a.class) {
                if (brN == null) {
                    brN = new a();
                }
            }
        }
        return brN;
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
