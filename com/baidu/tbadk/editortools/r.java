package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class r {
    public s aBT;
    public int aCG;
    public int aCI;
    public int aCJ;
    public int[] aCL;
    private Context context;
    public int id;
    public String name;
    public boolean aCH = true;
    public boolean aCK = false;

    public r(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aCI = i2;
    }

    public r(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public r(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.aCI = i2;
    }

    protected Context getContext() {
        return this.context;
    }

    public boolean lS() {
        return true;
    }

    public void bB(boolean z) {
    }
}
