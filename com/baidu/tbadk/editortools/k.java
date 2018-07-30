package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public int aMS;
    public int aMU;
    public int aMV;
    public int[] aMX;
    public l aMf;
    private Context context;
    public int id;
    public String name;
    public boolean aMT = true;
    public boolean aMW = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aMU = i2;
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
        this.aMU = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean oU() {
        return true;
    }

    public void bF(boolean z) {
    }
}
