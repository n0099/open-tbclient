package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a cka;
    private int mStatus = 0;

    public static a amm() {
        if (cka == null) {
            synchronized (a.class) {
                if (cka == null) {
                    cka = new a();
                }
            }
        }
        return cka;
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
