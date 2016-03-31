package com.baidu.tbadk.d.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    public int asA;
    private int asy;
    private int asz;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.asy = i;
        this.iconId = i2;
        this.asA = i3;
        this.asz = i4;
    }

    public int CO() {
        return this.iconId;
    }

    public int CQ() {
        return this.asy;
    }
}
