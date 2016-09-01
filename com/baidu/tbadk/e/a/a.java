package com.baidu.tbadk.e.a;

import android.content.Context;
/* loaded from: classes.dex */
public abstract class a {
    private int ata;
    private int atb;
    public int atc;
    private int iconId;
    private Context mContext;

    public a(Context context, int i, int i2, int i3, int i4) {
        this.mContext = context;
        this.ata = i;
        this.iconId = i2;
        this.atc = i3;
        this.atb = i4;
    }

    public int Cn() {
        return this.iconId;
    }

    public int Co() {
        return this.ata;
    }
}
