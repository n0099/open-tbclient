package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class v {
    public w aoI;
    public int apr;
    public int apt;
    public int apu;
    public int[] apw;
    private Context context;
    public int id;
    public String name;
    public boolean aps = true;
    public boolean apv = false;

    public v(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.apt = i2;
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
        this.apt = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
