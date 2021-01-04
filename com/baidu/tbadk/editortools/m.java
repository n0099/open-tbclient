package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n fDH;
    public int fEA;
    public int fEB;
    public int[] fED;
    public boolean fEE;
    public int fEu;
    public int fEv;
    public int fEw;
    public boolean fEx;
    public boolean fEy;
    public int id;
    public String name;
    public boolean fEz = true;
    public boolean fEC = false;
    private boolean fEF = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.fEA = i2;
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
        this.fEA = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean sj() {
        return true;
    }

    public boolean isEnable() {
        return true;
    }

    public void kR(boolean z) {
    }

    public void kS(boolean z) {
        this.fEF = z;
    }

    public boolean bEY() {
        return this.fEF;
    }
}
