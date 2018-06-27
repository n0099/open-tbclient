package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a aNJ;
    private int mStatus = 0;

    public static a HU() {
        if (aNJ == null) {
            synchronized (a.class) {
                if (aNJ == null) {
                    aNJ = new a();
                }
            }
        }
        return aNJ;
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
