package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public int bqN;
    public int bqP;
    public int bqQ;
    public int[] bqS;
    public s bqa;
    private Context context;
    public int id;
    public String name;
    public boolean bqO = true;
    public boolean bqR = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.bqP = i2;
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
        this.bqP = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean tv() {
        return true;
    }

    public void cd(boolean z) {
    }
}
