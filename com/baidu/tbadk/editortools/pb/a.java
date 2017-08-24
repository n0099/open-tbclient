package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aDP;
    private int mStatus = 0;

    public static a Dw() {
        if (aDP == null) {
            synchronized (a.class) {
                if (aDP == null) {
                    aDP = new a();
                }
            }
        }
        return aDP;
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
