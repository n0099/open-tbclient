package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n fhv;
    public int fij;
    public int fik;
    public int fil;
    public boolean fim;
    public boolean fin;
    public int fiq;
    public int fir;
    public int[] fit;
    public boolean fiu;
    public int id;
    public String name;
    public boolean fio = true;
    public boolean fis = false;
    private boolean fiv = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.fiq = i2;
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
        this.fiq = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sE() {
        return true;
    }

    public void jV(boolean z) {
    }

    public void jW(boolean z) {
        this.fiv = z;
    }

    public boolean bxo() {
        return this.fiv;
    }
}
