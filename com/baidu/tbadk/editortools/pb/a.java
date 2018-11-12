package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aWo;
    private int mStatus = 0;

    public static a Lp() {
        if (aWo == null) {
            synchronized (a.class) {
                if (aWo == null) {
                    aWo = new a();
                }
            }
        }
        return aWo;
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
