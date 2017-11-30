package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public s aBO;
    public int aCB;
    public int aCD;
    public int aCE;
    public int[] aCG;
    private Context context;
    public int id;
    public String name;
    public boolean aCC = true;
    public boolean aCF = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aCD = i2;
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
        this.aCD = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lS() {
        return true;
    }

    public void bA(boolean z) {
    }
}
