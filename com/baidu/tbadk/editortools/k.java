package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    public int aLW;
    public int aLY;
    public int aLZ;
    public l aLj;
    public int[] aMb;
    private Context context;
    public int id;
    public String name;
    public boolean aLX = true;
    public boolean aMa = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aLY = i2;
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
        this.aLY = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean oR() {
        return true;
    }

    public void bE(boolean z) {
    }
}
