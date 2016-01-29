package com.baidu.tbadk.d.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int asg;
    private int ash;
    public int asi;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.asg = i;
        this.iconId = i2;
        this.asi = i3;
        this.ash = i4;
    }

    public int Cj() {
        return this.iconId;
    }

    public int Ck() {
        return this.asg;
    }
}
