package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public int dsU;
    public int dsV;
    public boolean dsW;
    public int dsY;
    public int dsZ;
    public m dsh;
    public int[] dtb;
    public int id;
    public String name;
    public boolean dsX = true;
    public boolean dta = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.dsY = i2;
    }

    public l(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public l(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.dsY = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean lK() {
        return true;
    }

    public void gs(boolean z) {
    }
}
