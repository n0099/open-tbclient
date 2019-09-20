package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    private Context context;
    public l csV;
    public int ctI;
    public int ctJ;
    public boolean ctK;
    public int ctM;
    public int ctN;
    public int[] ctP;
    public int id;
    public String name;
    public boolean ctL = true;
    public boolean ctO = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.ctM = i2;
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
        this.ctM = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qA() {
        return true;
    }

    public void fn(boolean z) {
    }
}
