package com.baidu.tieba.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.lib.a.a {
    final /* synthetic */ bn a;
    private volatile com.baidu.tieba.d.t b;

    private bo(bn bnVar) {
        this.a = bnVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bo(bn bnVar, bo boVar) {
        this(bnVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.a.ax a(Object... objArr) {
        com.baidu.tieba.a.ax axVar;
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
            axVar = new com.baidu.tieba.a.ax();
            try {
                axVar.a(i);
                return axVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return axVar;
            }
        } catch (Exception e3) {
            axVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.g = null;
        super.cancel(true);
        eVar = this.a.b;
        eVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.ax axVar) {
        com.baidu.adp.a.e eVar;
        this.a.g = null;
        if (axVar == null && this.b != null) {
            this.a.c = this.b.d();
            this.a.d = this.b.f();
        }
        eVar = this.a.b;
        eVar.a(axVar);
    }
}
