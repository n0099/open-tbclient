package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aAu;
    private int mStatus = 0;

    public static a CI() {
        if (aAu == null) {
            synchronized (a.class) {
                if (aAu == null) {
                    aAu = new a();
                }
            }
        }
        return aAu;
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
