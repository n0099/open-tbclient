package com.baidu.tbadk.editortools.pb;
/* loaded from: classes2.dex */
public class a {
    private static a eMh;
    private int mStatus = 0;

    public static a brT() {
        if (eMh == null) {
            synchronized (a.class) {
                if (eMh == null) {
                    eMh = new a();
                }
            }
        }
        return eMh;
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
