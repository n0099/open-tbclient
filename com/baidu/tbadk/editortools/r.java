package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public s bpR;
    public int bqE;
    public int bqG;
    public int bqH;
    public int[] bqJ;
    private Context context;
    public int id;
    public String name;
    public boolean bqF = true;
    public boolean bqI = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.bqG = i2;
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
        this.bqG = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean tv() {
        return true;
    }

    public void cf(boolean z) {
    }
}
