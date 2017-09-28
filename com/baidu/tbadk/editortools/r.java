package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public s aAH;
    public int aBt;
    public int aBv;
    public int aBw;
    public int[] aBy;
    private Context context;
    public int id;
    public String name;
    public boolean aBu = true;
    public boolean aBx = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aBv = i2;
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
        this.aBv = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lV() {
        return true;
    }

    public void bF(boolean z) {
    }
}
