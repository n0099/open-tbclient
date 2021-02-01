package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a fDz;
    private int mStatus = 0;

    public static a bBK() {
        if (fDz == null) {
            synchronized (a.class) {
                if (fDz == null) {
                    fDz = new a();
                }
            }
        }
        return fDz;
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
