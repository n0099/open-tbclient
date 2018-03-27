package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public int bsZ;
    public s bsm;
    public int btb;
    public int btc;
    public int[] bte;
    private Context context;
    public int id;
    public String name;
    public boolean bta = true;
    public boolean btd = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.btb = i2;
    }

    public r(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public r(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.btb = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean tv() {
        return true;
    }

    public void ci(boolean z) {
    }
}
