package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a cGK;
    private int mStatus = 0;

    public static a auv() {
        if (cGK == null) {
            synchronized (a.class) {
                if (cGK == null) {
                    cGK = new a();
                }
            }
        }
        return cGK;
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
