package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class x {
    public int atW;
    public int atY;
    public int atZ;
    public y atm;
    public int[] aub;
    private Context context;
    public int id;
    public String name;
    public boolean atX = true;
    public boolean aua = false;

    public x(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.atY = i2;
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
        this.atY = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
