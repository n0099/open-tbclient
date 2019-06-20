package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    private Context context;
    public l cqF;
    public int cru;
    public int crw;
    public int crx;
    public int[] crz;
    public int id;
    public String name;
    public boolean crv = true;
    public boolean cry = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.crw = i2;
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
        this.crw = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    public boolean qd() {
        return true;
    }

    public void fg(boolean z) {
    }
}
