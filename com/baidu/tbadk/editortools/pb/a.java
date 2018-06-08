package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aMN;
    private int mStatus = 0;

    public static a HC() {
        if (aMN == null) {
            synchronized (a.class) {
                if (aMN == null) {
                    aMN = new a();
                }
            }
        }
        return aMN;
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
