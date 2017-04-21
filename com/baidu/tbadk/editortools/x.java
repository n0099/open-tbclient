package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class x {
    public y ayZ;
    public int azJ;
    public int azL;
    public int azM;
    public int[] azO;
    private Context context;
    public int id;
    public String name;
    public boolean azK = true;
    public boolean azN = false;

    public x(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.azL = i2;
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
        this.azL = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
