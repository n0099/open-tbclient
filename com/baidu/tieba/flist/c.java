package com.baidu.tieba.flist;
/* loaded from: classes.dex */
public final class c extends com.baidu.adp.a.d {
    private d a;
    private e b;
    private String c;
    private String d;
    private String e;
    private boolean f = false;
    private boolean g = false;

    public c(String str, String str2, String str3) {
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public final boolean LoadData() {
        this.a = new d(this, (byte) 0);
        this.a.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }

    public final void a(e eVar) {
        this.b = eVar;
    }
}
