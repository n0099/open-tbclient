package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aCu;
    private int mStatus = 0;

    public static a CV() {
        if (aCu == null) {
            synchronized (a.class) {
                if (aCu == null) {
                    aCu = new a();
                }
            }
        }
        return aCu;
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
