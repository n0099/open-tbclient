package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public int aYV;
    public int aYX;
    public int aYY;
    public l aYi;
    public int[] aZa;
    private Context context;
    public int id;
    public String name;
    public boolean aYW = true;
    public boolean aYZ = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aYX = i2;
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
        this.aYX = i2;
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
