package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    private Context context;
    public l crT;
    public int csH;
    public int csJ;
    public int csK;
    public int[] csM;
    public int id;
    public String name;
    public boolean csI = true;
    public boolean csL = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.csJ = i2;
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
        this.csJ = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qz() {
        return true;
    }

    public void fk(boolean z) {
    }
}
