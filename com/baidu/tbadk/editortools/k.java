package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public l aPu;
    public int aQh;
    public int aQj;
    public int aQk;
    public int[] aQm;
    private Context context;
    public int id;
    public String name;
    public boolean aQi = true;
    public boolean aQl = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aQj = i2;
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
        this.aQj = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean pX() {
        return true;
    }

    public void bS(boolean z) {
    }
}
