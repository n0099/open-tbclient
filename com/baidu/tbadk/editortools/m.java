package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public int fuO;
    public int fuP;
    public int fuQ;
    public boolean fuR;
    public boolean fuS;
    public int fuU;
    public int fuV;
    public int[] fuX;
    public boolean fuY;
    public n fub;
    public int id;
    public String name;
    public boolean fuT = true;
    public boolean fuW = false;
    private boolean fuZ = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.fuU = i2;
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
        this.fuU = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sH() {
        return true;
    }

    public boolean isEnable() {
        return true;
    }

    public void kv(boolean z) {
    }

    public void kw(boolean z) {
        this.fuZ = z;
    }

    public boolean bCD() {
        return this.fuZ;
    }
}
