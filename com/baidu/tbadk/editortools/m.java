package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n fCN;
    public int fDA;
    public int fDB;
    public int fDC;
    public boolean fDD;
    public boolean fDE;
    public int fDG;
    public int fDH;
    public int[] fDJ;
    public boolean fDK;
    public int id;
    public String name;
    public boolean fDF = true;
    public boolean fDI = false;
    private boolean fDL = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.fDG = i2;
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
        this.fDG = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sg() {
        return true;
    }

    public boolean isEnable() {
        return true;
    }

    public void kQ(boolean z) {
    }

    public void kR(boolean z) {
        this.fDL = z;
    }

    public boolean bBA() {
        return this.fDL;
    }
}
