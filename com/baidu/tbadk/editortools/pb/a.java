package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aDN;
    private int mStatus = 0;

    public static a Dw() {
        if (aDN == null) {
            synchronized (a.class) {
                if (aDN == null) {
                    aDN = new a();
                }
            }
        }
        return aDN;
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
