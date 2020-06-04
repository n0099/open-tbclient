package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a emz;
    private int mStatus = 0;

    public static a bdt() {
        if (emz == null) {
            synchronized (a.class) {
                if (emz == null) {
                    emz = new a();
                }
            }
        }
        return emz;
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
