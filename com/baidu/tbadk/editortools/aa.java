package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class aa {
    public ab aqi;
    public int arb;
    public int ard;
    public int are;
    public int[] arg;
    private Context context;
    public int id;
    public String name;
    public boolean arc = true;
    public boolean arf = false;

    public aa(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.ard = i2;
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
        this.ard = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
