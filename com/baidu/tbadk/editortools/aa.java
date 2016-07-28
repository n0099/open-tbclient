package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class aa {
    public ab aqX;
    public int arQ;
    public int arS;
    public int arT;
    public int[] arV;
    private Context context;
    public int id;
    public String name;
    public boolean arR = true;
    public boolean arU = false;

    public aa(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.arS = i2;
    }

    public aa(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public aa(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.arS = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
