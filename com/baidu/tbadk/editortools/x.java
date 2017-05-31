package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class x {
    public y ayJ;
    public int azt;
    public int azv;
    public int azw;
    public int[] azy;
    private Context context;
    public int id;
    public String name;
    public boolean azu = true;
    public boolean azx = false;

    public x(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.azv = i2;
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
        this.azv = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lX() {
        return true;
    }
}
