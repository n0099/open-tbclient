package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class aa {
    public int auX;
    public int auZ;
    public ab aue;
    public int ava;
    public int[] avc;
    private Context context;
    public int id;
    public String name;
    public boolean auY = true;
    public boolean avb = false;

    public aa(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.auZ = i2;
    }

    public aa(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public aa(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.auZ = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
