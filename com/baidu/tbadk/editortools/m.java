package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class m {
    private Context context;
    public n fBo;
    public int fCb;
    public int fCc;
    public int fCd;
    public boolean fCe;
    public boolean fCf;
    public int fCh;
    public int fCi;
    public int[] fCk;
    public boolean fCl;
    public int id;
    public String name;
    public boolean fCg = true;
    public boolean fCj = false;
    private boolean fCm = true;

    public m(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.fCh = i2;
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
        this.fCh = i2;
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
        this.fCm = z;
    }

    public boolean bBx() {
        return this.fCm;
    }
}
