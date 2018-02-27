package com.baidu.tbadk.editortools.pb;
/* loaded from: classes.dex */
public class a {
    private static a btO;
    private int mStatus = 0;

    public static a Lx() {
        if (btO == null) {
            synchronized (a.class) {
                if (btO == null) {
                    btO = new a();
                }
            }
        }
        return btO;
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
