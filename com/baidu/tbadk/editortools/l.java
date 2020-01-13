package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class l {
    private Context context;
    public m dss;
    public int dtf;
    public int dtg;
    public boolean dth;
    public int dtj;
    public int dtk;
    public int[] dtm;
    public int id;
    public String name;
    public boolean dti = true;
    public boolean dtl = false;

    public l(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.dtj = i2;
    }

    public l(Context context, String str, int i) {
        this.name = str;
        this.id = i;
        this.context = context;
    }

    public l(Context context, String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.context = context;
        this.dtj = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean lK() {
        return true;
    }

    public void gx(boolean z) {
    }
}
