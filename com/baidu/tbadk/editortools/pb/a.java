package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aCQ;
    private int mStatus = 0;

    public static a Dd() {
        if (aCQ == null) {
            synchronized (a.class) {
                if (aCQ == null) {
                    aCQ = new a();
                }
            }
        }
        return aCQ;
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
