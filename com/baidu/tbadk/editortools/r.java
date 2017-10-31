package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public int aBQ;
    public int aBS;
    public int aBT;
    public int[] aBV;
    public s aBf;
    private Context context;
    public int id;
    public String name;
    public boolean aBR = true;
    public boolean aBU = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aBS = i2;
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
        this.aBS = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lP() {
        return true;
    }

    public void bz(boolean z) {
    }
}
