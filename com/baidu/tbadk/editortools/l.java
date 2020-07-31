package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public int eAM;
    public int eAN;
    public int eAO;
    public boolean eAP;
    public int eAR;
    public int eAS;
    public int[] eAU;
    public boolean eAV;
    public m ezZ;
    public int id;
    public String name;
    public boolean eAQ = true;
    public boolean eAT = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.eAR = i2;
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
        this.eAR = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean ra() {
        return true;
    }

    public void iM(boolean z) {
    }
}
