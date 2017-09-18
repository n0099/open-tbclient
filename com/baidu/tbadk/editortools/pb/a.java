package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aDd;
    private int mStatus = 0;

    public static a Dr() {
        if (aDd == null) {
            synchronized (a.class) {
                if (aDd == null) {
                    aDd = new a();
                }
            }
        }
        return aDd;
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
