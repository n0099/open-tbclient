package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public int aBZ;
    public s aBn;
    public int aCb;
    public int aCc;
    public int[] aCe;
    private Context context;
    public int id;
    public String name;
    public boolean aCa = true;
    public boolean aCd = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aCb = i2;
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
        this.aCb = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lT() {
        return true;
    }

    public void bG(boolean z) {
    }
}
