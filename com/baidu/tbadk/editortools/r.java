package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public s aAL;
    public int[] aBB;
    public int aBw;
    public int aBy;
    public int aBz;
    private Context context;
    public int id;
    public String name;
    public boolean aBx = true;
    public boolean aBA = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aBy = i2;
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
        this.aBy = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lS() {
        return true;
    }

    public void bH(boolean z) {
    }
}
