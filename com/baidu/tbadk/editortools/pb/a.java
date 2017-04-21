package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aAK;
    private int mStatus = 0;

    public static a DK() {
        if (aAK == null) {
            synchronized (a.class) {
                if (aAK == null) {
                    aAK = new a();
                }
            }
        }
        return aAK;
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
