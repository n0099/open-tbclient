package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public int aYY;
    public l aYl;
    public int aZa;
    public int aZb;
    public int[] aZd;
    private Context context;
    public int id;
    public String name;
    public boolean aYZ = true;
    public boolean aZc = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aZa = i2;
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
        this.aZa = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qb() {
        return true;
    }

    public void ct(boolean z) {
    }
}
