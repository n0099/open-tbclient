package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n eKB;
    public int eLo;
    public int eLp;
    public int eLq;
    public boolean eLr;
    public boolean eLs;
    public int eLu;
    public int eLv;
    public int[] eLx;
    public boolean eLy;
    public int id;
    public String name;
    public boolean eLt = true;
    public boolean eLw = false;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.eLu = i2;
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
        this.eLu = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sz() {
        return true;
    }

    public void jm(boolean z) {
    }
}
