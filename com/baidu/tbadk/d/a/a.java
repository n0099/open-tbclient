package com.baidu.tbadk.d.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int apL;
    private int apM;
    public int apN;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.apL = i;
        this.iconId = i2;
        this.apN = i3;
        this.apM = i4;
    }

    public int Bd() {
        return this.iconId;
    }

    public int Be() {
        return this.apL;
    }
}
