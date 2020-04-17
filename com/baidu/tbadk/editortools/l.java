package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public m dWH;
    public int[] dXA;
    public int dXt;
    public int dXu;
    public boolean dXv;
    public int dXx;
    public int dXy;
    public int id;
    public String name;
    public boolean dXw = true;
    public boolean dXz = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.dXx = i2;
    }

    public l(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public l(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.dXx = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qB() {
        return true;
    }

    public void hD(boolean z) {
    }
}
