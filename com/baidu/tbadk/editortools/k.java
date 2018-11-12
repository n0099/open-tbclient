package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public l aUL;
    public int aVA;
    public int aVB;
    public int[] aVD;
    public int aVy;
    private Context context;
    public int id;
    public String name;
    public boolean aVz = true;
    public boolean aVC = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aVA = i2;
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
        this.aVA = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qc() {
        return true;
    }

    public void cs(boolean z) {
    }
}
