package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n fnp;
    public int foc;
    public int fod;
    public int foe;
    public boolean fof;
    public boolean fog;
    public int foi;
    public int foj;
    public int[] fol;
    public boolean fom;
    public int id;
    public String name;
    public boolean foh = true;
    public boolean fok = false;
    private boolean fon = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.foi = i2;
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
        this.foi = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sE() {
        return true;
    }

    public void ke(boolean z) {
    }

    public void kf(boolean z) {
        this.fon = z;
    }

    public boolean bzN() {
        return this.fon;
    }
}
