package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class v {
    public w aox;
    public int apf;
    public int aph;
    public int api;
    public int[] apk;
    private Context context;
    public int id;
    public String name;
    public boolean apg = true;
    public boolean apj = false;

    public v(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aph = i2;
    }

    public v(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public v(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.aph = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
