package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public int aCP;
    public int aCR;
    public int aCS;
    public int[] aCU;
    public s aCe;
    private Context context;
    public int id;
    public String name;
    public boolean aCQ = true;
    public boolean aCT = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aCR = i2;
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
        this.aCR = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean mb() {
        return true;
    }

    public void bH(boolean z) {
    }
}
