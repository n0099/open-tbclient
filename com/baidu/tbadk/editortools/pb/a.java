package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a fpA;
    private int mStatus = 0;

    public static a bAa() {
        if (fpA == null) {
            synchronized (a.class) {
                if (fpA == null) {
                    fpA = new a();
                }
            }
        }
        return fpA;
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
