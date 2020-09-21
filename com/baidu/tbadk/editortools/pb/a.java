package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a ePc;
    private int mStatus = 0;

    public static a bsY() {
        if (ePc == null) {
            synchronized (a.class) {
                if (ePc == null) {
                    ePc = new a();
                }
            }
        }
        return ePc;
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
