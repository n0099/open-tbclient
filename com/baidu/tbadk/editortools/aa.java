package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class aa {
    public ab atI;
    public int auA;
    public int auC;
    public int auD;
    public int[] auF;
    private Context context;
    public int id;
    public String name;
    public boolean auB = true;
    public boolean auE = false;

    public aa(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.auC = i2;
    }

    public aa(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public aa(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.auC = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
