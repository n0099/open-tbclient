package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class x {
    public y ayX;
    public int azH;
    public int azJ;
    public int azK;
    public int[] azM;
    private Context context;
    public int id;
    public String name;
    public boolean azI = true;
    public boolean azL = false;

    public x(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.azJ = i2;
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
        this.azJ = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
