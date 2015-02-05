package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class e {
    private int Xg;
    private boolean acA = false;
    private int acy;
    private int acz;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public e(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.Xg = i;
        this.iconId = i2;
        this.acy = i3;
        this.acz = i4;
    }

    public void aN(boolean z) {
        this.acA = z;
    }

    public void dA(int i) {
        this.acz = i;
    }

    public int wr() {
        return this.acz;
    }
}
