package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a foH;
    private int mStatus = 0;

    public static a bzq() {
        if (foH == null) {
            synchronized (a.class) {
                if (foH == null) {
                    foH = new a();
                }
            }
        }
        return foH;
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
