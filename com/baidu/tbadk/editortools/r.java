package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public s aBq;
    public int aCc;
    public int aCe;
    public int aCf;
    public int[] aCh;
    private Context context;
    public int id;
    public String name;
    public boolean aCd = true;
    public boolean aCg = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aCe = i2;
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
        this.aCe = i2;
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
