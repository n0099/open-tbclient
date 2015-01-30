package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class e {
    private int Xj;
    private int acB;
    private int acC;
    private boolean acD = false;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public e(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.Xj = i;
        this.iconId = i2;
        this.acB = i3;
        this.acC = i4;
    }

    public void aN(boolean z) {
        this.acD = z;
    }

    public void dA(int i) {
        this.acC = i;
    }

    public int wx() {
        return this.acC;
    }
}
