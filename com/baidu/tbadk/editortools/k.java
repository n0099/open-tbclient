package com.baidu.tbadk.editortools;

import android.content.Context;
/* loaded from: classes.dex */
public class k {
    private Context context;
    public l cqE;
    public int crt;
    public int crv;
    public int crw;
    public int[] cry;
    public int id;
    public String name;
    public boolean cru = true;
    public boolean crx = false;

    public k(String str, int i, int i2) {
        this.name = str;
        this.id = i;
        this.crv = i2;
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
        this.crv = i2;
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
