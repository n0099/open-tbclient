package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a ctE;
    private int mStatus = 0;

    public static a asx() {
        if (ctE == null) {
            synchronized (a.class) {
                if (ctE == null) {
                    ctE = new a();
                }
            }
        }
        return ctE;
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
