package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class v {
    public int aqQ;
    public int aqS;
    public int aqT;
    public int[] aqV;
    public w aqi;
    private Context context;
    public int id;
    public String name;
    public boolean aqR = true;
    public boolean aqU = false;

    public v(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.aqS = i2;
    }

    public v(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public v(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.aqS = i2;
    }

    protected Context getContext() {
        return this.context;
    }
}
