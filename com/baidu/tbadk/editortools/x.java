package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class x {
    public y ayH;
    public int azr;
    public int azt;
    public int azu;
    public int[] azw;
    private Context context;
    public int id;
    public String name;
    public boolean azs = true;
    public boolean azv = false;

    public x(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.azt = i2;
    }

    public x(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public x(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.azt = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
