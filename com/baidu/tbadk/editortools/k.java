package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public l ciw;
    public int cjk;
    public int cjm;
    public int cjn;
    public int[] cjp;
    private Context context;
    public int id;
    public String name;
    public boolean cjl = true;
    public boolean cjo = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.cjm = i2;
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
        this.cjm = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean ri() {
        return true;
    }

    public void eK(boolean z) {
    }
}
