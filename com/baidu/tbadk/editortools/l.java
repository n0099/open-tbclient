package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public m dwA;
    public int dxm;
    public int dxn;
    public boolean dxo;
    public int dxq;
    public int dxr;
    public int[] dxt;
    public int id;
    public String name;
    public boolean dxp = true;
    public boolean dxs = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.dxq = i2;
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
        this.dxq = i2;
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
