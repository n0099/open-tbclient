package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class v {
    public w aoJ;
    public int aps;
    public int apu;
    public int apv;
    public int[] apx;
    private Context context;
    public int id;
    public String name;
    public boolean apt = true;
    public boolean apw = false;

    public v(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.apu = i2;
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
        this.apu = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
