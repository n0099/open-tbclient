package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a dtM;
    private int mStatus = 0;

    public static a aLY() {
        if (dtM == null) {
            synchronized (a.class) {
                if (dtM == null) {
                    dtM = new a();
                }
            }
        }
        return dtM;
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
