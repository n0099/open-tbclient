package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n fmx;
    public int fnk;
    public int fnl;
    public int fnm;
    public boolean fnn;
    public boolean fno;
    public int fnq;
    public int fnr;
    public int[] fnt;
    public boolean fnu;
    public int id;
    public String name;
    public boolean fnp = true;
    public boolean fns = false;
    private boolean fnv = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.fnq = i2;
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
        this.fnq = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sE() {
        return true;
    }

    public void kf(boolean z) {
    }

    public void kg(boolean z) {
        this.fnv = z;
    }

    public boolean bzd() {
        return this.fnv;
    }
}
