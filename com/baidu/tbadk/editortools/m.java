package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n fyZ;
    public int fzM;
    public int fzN;
    public int fzO;
    public boolean fzP;
    public boolean fzQ;
    public int fzS;
    public int fzT;
    public int[] fzV;
    public boolean fzW;
    public int id;
    public String name;
    public boolean fzR = true;
    public boolean fzU = false;
    private boolean fzX = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.fzS = i2;
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
        this.fzS = i2;
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

    public void kN(boolean z) {
    }

    public void kO(boolean z) {
        this.fzX = z;
    }

    public boolean bBf() {
        return this.fzX;
    }
}
