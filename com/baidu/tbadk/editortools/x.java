package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class x {
    public int auR;
    public int auT;
    public int auU;
    public int[] auW;
    public y auh;
    private Context context;
    public int id;
    public String name;
    public boolean auS = true;
    public boolean auV = false;

    public x(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.auT = i2;
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
        this.auT = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
