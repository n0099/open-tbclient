package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public s bsw;
    public int btj;
    public int btl;
    public int btm;
    public int[] btp;
    private Context context;
    public int id;
    public String name;
    public boolean btk = true;
    public boolean bto = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.btl = i2;
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
        this.btl = i2;
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
