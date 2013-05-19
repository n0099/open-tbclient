package com.baidu.tieba.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.lib.a.a {
    final /* synthetic */ i a;
    private com.baidu.tieba.d.t b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public l(i iVar, String str, String str2, String str3, String str4, String str5) {
        this.a = iVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        this.b = new com.baidu.tieba.d.t(strArr[0]);
        this.b.a("day", this.g);
        this.b.a("un", this.f);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        this.b.a("ntn", "banid");
        this.b.d(true);
        this.b.i();
        if (this.b.b()) {
            return null;
        }
        return this.b.f();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.f = null;
        super.cancel(true);
        eVar = this.a.b;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) str);
        this.a.f = null;
        if (this.b == null) {
            eVar2 = this.a.b;
            eVar2.a(null);
            return;
        }
        m mVar = new m(this.a);
        if (str == null) {
            mVar.a = true;
        } else {
            mVar.a = false;
            mVar.b = str;
        }
        eVar = this.a.b;
        eVar.a(mVar);
    }
}
