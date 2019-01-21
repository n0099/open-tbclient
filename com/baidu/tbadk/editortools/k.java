package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public l aYW;
    public int aZJ;
    public int aZL;
    public int aZM;
    public int[] aZO;
    private Context context;
    public int id;
    public String name;
    public boolean aZK = true;
    public boolean aZN = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aZL = i2;
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
        this.aZL = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qf() {
        return true;
    }

    public void cw(boolean z) {
    }
}
