package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a ckb;
    private int mStatus = 0;

    public static a amm() {
        if (ckb == null) {
            synchronized (a.class) {
                if (ckb == null) {
                    ckb = new a();
                }
            }
        }
        return ckb;
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
