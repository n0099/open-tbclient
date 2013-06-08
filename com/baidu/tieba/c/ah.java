package com.baidu.tieba.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.lib.a.a {
    final /* synthetic */ ag a;
    private volatile com.baidu.tieba.d.t b;

    private ah(ag agVar) {
        this.a = agVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(ag agVar, ah ahVar) {
        this(agVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.ac a(Object... objArr) {
        String str;
        String str2;
        try {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/forum/like");
            com.baidu.tieba.d.t tVar = this.b;
            str = this.a.e;
            tVar.a("kw", str);
            com.baidu.tieba.d.t tVar2 = this.b;
            str2 = this.a.f;
            tVar2.a("fid", str2);
            this.b.d(true);
            String i = this.b.i();
            if (this.b.b() && i != null) {
                com.baidu.tieba.a.ac acVar = new com.baidu.tieba.a.ac();
                acVar.a(i);
                return acVar;
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.ac acVar) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.a.g = null;
        if (acVar == null && this.b != null) {
            this.a.c = this.b.d();
            this.a.d = this.b.f();
        }
        eVar = this.a.b;
        if (eVar != null) {
            eVar2 = this.a.b;
            eVar2.a(acVar);
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
}
