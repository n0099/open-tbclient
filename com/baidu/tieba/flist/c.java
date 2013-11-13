package com.baidu.tieba.flist;

import android.content.Context;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private e f1247a;
    private f b;
    private String c;
    private String d;
    private String e;
    private boolean f = false;
    private boolean g = false;

    public c(Context context, String str, String str2, String str3) {
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        this.f1247a = new e(this);
        this.f1247a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.f1247a != null) {
            this.f1247a.cancel();
            return false;
        }
        return false;
    }

    public void a(f fVar) {
        this.b = fVar;
    }
}
