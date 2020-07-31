package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a eBI;
    private int mStatus = 0;

    public static a bjh() {
        if (eBI == null) {
            synchronized (a.class) {
                if (eBI == null) {
                    eBI = new a();
                }
            }
        }
        return eBI;
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
