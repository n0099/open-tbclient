package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class aa {
    public ab auC;
    public int avu;
    public int avw;
    public int avx;
    public int[] avz;
    private Context context;
    public int id;
    public String name;
    public boolean avv = true;
    public boolean avy = false;

    public aa(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.avw = i2;
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
        this.avw = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
