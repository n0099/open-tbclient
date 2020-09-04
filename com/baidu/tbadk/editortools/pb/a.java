package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a eMl;
    private int mStatus = 0;

    public static a brU() {
        if (eMl == null) {
            synchronized (a.class) {
                if (eMl == null) {
                    eMl = new a();
                }
            }
        }
        return eMl;
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
