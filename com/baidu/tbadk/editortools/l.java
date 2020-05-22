package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public m ekV;
    public int elH;
    public int elI;
    public boolean elJ;
    public int elL;
    public int elM;
    public int[] elO;
    public int id;
    public String name;
    public boolean elK = true;
    public boolean elN = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.elL = i2;
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
        this.elL = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qH() {
        return true;
    }

    public void hZ(boolean z) {
    }
}
