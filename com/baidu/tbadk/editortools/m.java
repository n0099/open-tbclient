package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n eMS;
    public int eNF;
    public int eNG;
    public int eNH;
    public boolean eNI;
    public boolean eNJ;
    public int eNL;
    public int eNM;
    public int[] eNO;
    public boolean eNP;
    public int id;
    public String name;
    public boolean eNK = true;
    public boolean eNN = false;
    private boolean eNQ = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.eNL = i2;
    }

    public m(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public m(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.eNL = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sE() {
        return true;
    }

    public void jk(boolean z) {
    }

    public void jl(boolean z) {
        this.eNQ = z;
    }

    public boolean bsL() {
        return this.eNQ;
    }
}
