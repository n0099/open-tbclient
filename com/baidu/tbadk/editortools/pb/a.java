package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a auX;
    private int mStatus = 0;

    public static a CT() {
        if (auX == null) {
            synchronized (a.class) {
                if (auX == null) {
                    auX = new a();
                }
            }
        }
        return auX;
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
