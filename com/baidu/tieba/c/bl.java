package com.baidu.tieba.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends com.baidu.adp.lib.a.a {
    final /* synthetic */ bk a;
    private volatile com.baidu.tieba.d.t b;

    private bl(bk bkVar) {
        this.a = bkVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bl(bk bkVar, bl blVar) {
        this(bkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.aw a(Object... objArr) {
        com.baidu.tieba.a.aw awVar;
        Exception e;
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/forum/sign");
            com.baidu.tieba.d.t tVar = this.b;
            str = this.a.e;
            tVar.a("kw", str);
            com.baidu.tieba.d.t tVar2 = this.b;
            str2 = this.a.f;
            tVar2.a("fid", str2);
            this.b.d(true);
            String i = this.b.i();
            if (!this.b.c() || !this.b.b()) {
                return null;
            }
            awVar = new com.baidu.tieba.a.aw();
            try {
                awVar.a(i);
                return awVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return awVar;
            }
        } catch (Exception e3) {
            awVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.g = null;
        super.cancel(true);
        eVar = this.a.b;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.aw awVar) {
        com.baidu.adp.a.e eVar;
        this.a.g = null;
        if (awVar == null) {
            this.a.c = this.b.d();
            this.a.d = this.b.f();
        }
        eVar = this.a.b;
        eVar.a(awVar);
    }
}
