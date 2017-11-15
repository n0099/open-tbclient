package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public int aBY;
    public s aBn;
    public int aCa;
    public int aCb;
    public int[] aCd;
    private Context context;
    public int id;
    public String name;
    public boolean aBZ = true;
    public boolean aCc = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aCa = i2;
    }

    public r(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public r(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.aCa = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lP() {
        return true;
    }

    public void bA(boolean z) {
    }
}
