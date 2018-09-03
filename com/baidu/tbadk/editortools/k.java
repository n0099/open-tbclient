package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public int aMP;
    public int aMR;
    public int aMS;
    public int[] aMU;
    public l aMc;
    private Context context;
    public int id;
    public String name;
    public boolean aMQ = true;
    public boolean aMT = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aMR = i2;
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
        this.aMR = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean oR() {
        return true;
    }

    public void bG(boolean z) {
    }
}
