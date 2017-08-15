package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aDO;
    private int mStatus = 0;

    public static a Dw() {
        if (aDO == null) {
            synchronized (a.class) {
                if (aDO == null) {
                    aDO = new a();
                }
            }
        }
        return aDO;
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
