package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aDt;
    private int mStatus = 0;

    public static a Dy() {
        if (aDt == null) {
            synchronized (a.class) {
                if (aDt == null) {
                    aDt = new a();
                }
            }
        }
        return aDt;
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
