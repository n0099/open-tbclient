package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aZL;
    private int mStatus = 0;

    public static a Mt() {
        if (aZL == null) {
            synchronized (a.class) {
                if (aZL == null) {
                    aZL = new a();
                }
            }
        }
        return aZL;
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
