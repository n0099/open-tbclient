package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class x {
    public int[] aAB;
    public int aAw;
    public int aAy;
    public int aAz;
    public y azL;
    private Context context;
    public int id;
    public String name;
    public boolean aAx = true;
    public boolean aAA = false;

    public x(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aAy = i2;
    }

    public x(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public x(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.aAy = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lV() {
        return true;
    }

    public void bE(boolean z) {
    }
}
