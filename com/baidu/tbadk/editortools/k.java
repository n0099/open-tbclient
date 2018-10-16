package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public l aTV;
    public int aUI;
    public int aUK;
    public int aUL;
    public int[] aUN;
    private Context context;
    public int id;
    public String name;
    public boolean aUJ = true;
    public boolean aUM = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aUK = i2;
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
        this.aUK = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qe() {
        return true;
    }

    public void cb(boolean z) {
    }
}
