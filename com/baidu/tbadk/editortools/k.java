package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public l aCN;
    public int aDA;
    public int aDC;
    public int aDD;
    public int[] aDF;
    private Context context;
    public int id;
    public String name;
    public boolean aDB = true;
    public boolean aDE = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aDC = i2;
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
        this.aDC = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean ma() {
        return true;
    }

    public void bA(boolean z) {
    }
}
