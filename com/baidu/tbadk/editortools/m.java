package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes2.dex */
public class m {
    private Context context;
    public n eKx;
    public int eLk;
    public int eLl;
    public int eLm;
    public boolean eLn;
    public boolean eLo;
    public int eLq;
    public int eLr;
    public int[] eLt;
    public boolean eLu;
    public int id;
    public String name;
    public boolean eLp = true;
    public boolean eLs = false;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.eLq = i2;
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
        this.eLq = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sz() {
        return true;
    }

    public void jk(boolean z) {
    }
}
