package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public m dwN;
    public int dxA;
    public boolean dxB;
    public int dxD;
    public int dxE;
    public int[] dxG;
    public int dxz;
    public int id;
    public String name;
    public boolean dxC = true;
    public boolean dxF = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.dxD = i2;
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
        this.dxD = i2;
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
