package com.baidu.tbadk.mainTab;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class e {
    private int WE;
    private int acd;
    private int ace;
    private boolean acf = false;
    private int iconId;
    private Context mContext;

    public abstract void onClick();

    public e(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.WE = i;
        this.iconId = i2;
        this.acd = i3;
        this.ace = i4;
    }

    public boolean wf() {
        return this.acf;
    }

    public void aL(boolean z) {
        this.acf = z;
    }

    public int uB() {
        return this.iconId;
    }

    public int uC() {
        return this.WE;
    }

    public void du(int i) {
        this.ace = i;
    }

    public int wg() {
        return this.ace;
    }

    public int wh() {
        return this.acd;
    }
}
