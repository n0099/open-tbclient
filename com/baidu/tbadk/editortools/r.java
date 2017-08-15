package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public int aCO;
    public int aCQ;
    public int aCR;
    public int[] aCT;
    public s aCd;
    private Context context;
    public int id;
    public String name;
    public boolean aCP = true;
    public boolean aCS = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aCQ = i2;
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
        this.aCQ = i2;
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
