package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public l cEn;
    public int cFa;
    public int cFb;
    public boolean cFc;
    public int cFe;
    public int cFf;
    public int[] cFh;
    private Context context;
    public int id;
    public String name;
    public boolean cFd = true;
    public boolean cFg = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.cFe = i2;
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
        this.cFe = i2;
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
