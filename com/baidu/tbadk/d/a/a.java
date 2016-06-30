package com.baidu.tbadk.d.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int apd;
    private int ape;
    public int apf;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.apd = i;
        this.iconId = i2;
        this.apf = i3;
        this.ape = i4;
    }

    public int AS() {
        return this.iconId;
    }

    public int AT() {
        return this.apd;
    }
}
