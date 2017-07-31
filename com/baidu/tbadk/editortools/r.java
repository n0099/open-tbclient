package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public int aCN;
    public int aCP;
    public int aCQ;
    public int[] aCS;
    public s aCc;
    private Context context;
    public int id;
    public String name;
    public boolean aCO = true;
    public boolean aCR = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aCP = i2;
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
        this.aCP = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean mc() {
        return true;
    }

    public void bH(boolean z) {
    }
}
