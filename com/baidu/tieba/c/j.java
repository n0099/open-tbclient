package com.baidu.tieba.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.a.a {
    final /* synthetic */ i a;
    private com.baidu.tieba.d.t b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;

    public j(i iVar, String str, String str2, String str3, String str4, int i, int i2) {
        this.a = iVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
        this.h = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        String str;
        String str2 = com.baidu.tieba.a.i.e;
        if (this.g == 0) {
            str = String.valueOf(str2) + "c/c/bawu/delthread";
        } else {
            str = String.valueOf(str2) + "c/c/bawu/delpost";
        }
        this.b = new com.baidu.tieba.d.t(str);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        if (this.g == 0) {
            if (this.h == 0) {
                this.b.a("delete_my_thread", "1");
            }
        } else if (this.g == 1) {
            this.b.a("pid", this.f);
            this.b.a("isfloor", "0");
            this.b.a("src", "1");
        } else if (this.g == 2) {
            this.b.a("pid", this.f);
            this.b.a("isfloor", "1");
            this.b.a("src", "3");
        }
        if (this.h == 0) {
            this.b.a("is_vipdel", "1");
        } else {
            this.b.a("is_vipdel", "0");
        }
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
        this.a.e = null;
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
        this.a.e = null;
        if (this.b == null) {
            eVar2 = this.a.b;
            eVar2.a(null);
            return;
        }
        k kVar = new k(this.a);
        kVar.c = this.g;
        kVar.d = this.f;
        kVar.b = str;
        if (str == null) {
            kVar.a = true;
        } else {
            kVar.a = false;
        }
        eVar = this.a.b;
        eVar.a(kVar);
    }
}
