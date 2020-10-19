package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n eYZ;
    public int eZM;
    public int eZN;
    public int eZO;
    public boolean eZP;
    public boolean eZQ;
    public int eZS;
    public int eZT;
    public int[] eZV;
    public boolean eZW;
    public int id;
    public String name;
    public boolean eZR = true;
    public boolean eZU = false;
    private boolean eZX = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.eZS = i2;
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
        this.eZS = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sE() {
        return true;
    }

    public void jI(boolean z) {
    }

    public void jJ(boolean z) {
        this.eZX = z;
    }

    public boolean bvv() {
        return this.eZX;
    }
}
