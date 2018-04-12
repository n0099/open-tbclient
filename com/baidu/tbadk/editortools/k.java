package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public l aCM;
    public int aDB;
    public int aDC;
    public int[] aDE;
    public int aDz;
    private Context context;
    public int id;
    public String name;
    public boolean aDA = true;
    public boolean aDD = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aDB = i2;
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
        this.aDB = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean mb() {
        return true;
    }

    public void bA(boolean z) {
    }
}
