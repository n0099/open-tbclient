package com.baidu.tieba.flist;

import android.content.Context;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private d f1039a;
    private e b;
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
    @Override // com.baidu.adp.a.c
    public boolean LoadData() {
        this.f1039a = new d(this, null);
        this.f1039a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.f1039a != null) {
            this.f1039a.cancel();
            return false;
        }
        return false;
    }

    public void a(e eVar) {
        this.b = eVar;
    }
}
