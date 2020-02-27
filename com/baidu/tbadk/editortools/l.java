package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public m dwz;
    public int dxl;
    public int dxm;
    public boolean dxn;
    public int dxp;
    public int dxq;
    public int[] dxs;
    public int id;
    public String name;
    public boolean dxo = true;
    public boolean dxr = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.dxp = i2;
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
        this.dxp = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean lZ() {
        return true;
    }

    public void gE(boolean z) {
    }
}
