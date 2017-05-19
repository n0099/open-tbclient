package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aAI;
    private int mStatus = 0;

    public static a CO() {
        if (aAI == null) {
            synchronized (a.class) {
                if (aAI == null) {
                    aAI = new a();
                }
            }
        }
        return aAI;
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
