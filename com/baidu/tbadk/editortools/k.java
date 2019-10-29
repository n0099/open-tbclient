package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public int cFR;
    public int cFS;
    public boolean cFT;
    public int cFV;
    public int cFW;
    public int[] cFY;
    public l cFe;
    private Context context;
    public int id;
    public String name;
    public boolean cFU = true;
    public boolean cFX = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.cFV = i2;
    }

    public k(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public k(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.cFV = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean lt() {
        return true;
    }

    public void fh(boolean z) {
    }
}
