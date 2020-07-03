package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public m etH;
    public int[] euB;
    public boolean euC;
    public int eut;
    public int euu;
    public int euv;
    public boolean euw;
    public int euy;
    public int euz;
    public int id;
    public String name;
    public boolean eux = true;
    public boolean euA = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.euy = i2;
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
        this.euy = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qY() {
        return true;
    }

    public void ii(boolean z) {
    }
}
