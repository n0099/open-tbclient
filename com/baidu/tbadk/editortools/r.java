package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public s aBW;
    public int aCJ;
    public int aCL;
    public int aCM;
    public int[] aCO;
    private Context context;
    public int id;
    public String name;
    public boolean aCK = true;
    public boolean aCN = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aCL = i2;
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
        this.aCL = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lS() {
        return true;
    }

    public void bB(boolean z) {
    }
}
