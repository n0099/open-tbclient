package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public int bqW;
    public int bqY;
    public int bqZ;
    public s bqj;
    public int[] brb;
    private Context context;
    public int id;
    public String name;
    public boolean bqX = true;
    public boolean bra = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.bqY = i2;
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
        this.bqY = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean tw() {
        return true;
    }

    public void ce(boolean z) {
    }
}
