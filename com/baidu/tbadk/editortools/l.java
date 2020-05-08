package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public m dWM;
    public boolean dXA;
    public int dXC;
    public int dXD;
    public int[] dXF;
    public int dXy;
    public int dXz;
    public int id;
    public String name;
    public boolean dXB = true;
    public boolean dXE = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.dXC = i2;
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
        this.dXC = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qB() {
        return true;
    }

    public void hD(boolean z) {
    }
}
