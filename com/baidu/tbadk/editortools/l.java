package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public int dxM;
    public int dxN;
    public boolean dxO;
    public int dxQ;
    public int dxR;
    public int[] dxT;
    public m dxa;
    public int id;
    public String name;
    public boolean dxP = true;
    public boolean dxS = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.dxQ = i2;
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
        this.dxQ = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean lZ() {
        return true;
    }

    public void gF(boolean z) {
    }
}
