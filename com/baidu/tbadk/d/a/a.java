package com.baidu.tbadk.d.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int apT;
    private int apU;
    public int apV;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.apT = i;
        this.iconId = i2;
        this.apV = i3;
        this.apU = i4;
    }

    public int AS() {
        return this.iconId;
    }

    public int AT() {
        return this.apT;
    }
}
