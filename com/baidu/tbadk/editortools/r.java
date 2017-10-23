package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public s aAv;
    public int aBh;
    public int aBj;
    public int aBk;
    public int[] aBm;
    private Context context;
    public int id;
    public String name;
    public boolean aBi = true;
    public boolean aBl = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aBj = i2;
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
        this.aBj = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lV() {
        return true;
    }

    public void bE(boolean z) {
    }
}
