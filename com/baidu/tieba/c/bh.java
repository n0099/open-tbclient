package com.baidu.tieba.c;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends com.baidu.adp.lib.a.a {
    final /* synthetic */ bf a;
    private com.baidu.tieba.d.t b;
    private volatile boolean c;
    private boolean d;

    private bh(bf bfVar) {
        this.a = bfVar;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bh(bf bfVar, bh bhVar) {
        this(bfVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.a.bd a(Boolean... boolArr) {
        com.baidu.tieba.a.bd bdVar;
        Exception e;
        String d;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.a.e() && booleanValue && (d = com.baidu.tieba.d.k.d()) != null) {
                com.baidu.tieba.a.bd bdVar2 = new com.baidu.tieba.a.bd();
                bdVar2.e(d);
                c(bdVar2);
                this.d = false;
            }
            if (!this.c && this.a.d() != null) {
                this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/u/user/profile");
                this.b.a("uid", this.a.d());
                String i = this.b.i();
                if (this.b.b()) {
                    bdVar = new com.baidu.tieba.a.bd();
                    try {
                        JSONObject optJSONObject = new JSONObject(i).optJSONObject("user");
                        bdVar.a(optJSONObject);
                        if (this.a.e()) {
                            com.baidu.tieba.d.k.g(optJSONObject.toString());
                            return bdVar;
                        }
                        return bdVar;
                    } catch (Exception e2) {
                        e = e2;
                        com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                        return bdVar;
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            bdVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: a */
    public void b(com.baidu.tieba.a.bd... bdVarArr) {
        com.baidu.adp.a.e eVar;
        boolean z = false;
        super.b((Object[]) bdVarArr);
        com.baidu.tieba.a.bd bdVar = bdVarArr[0];
        if (bdVar != null) {
            this.a.a(bdVar);
            z = true;
        }
        this.a.a = 2;
        this.a.a((String) null);
        eVar = this.a.b;
        eVar.a(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.bd bdVar) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) bdVar);
        this.a.o = null;
        if (bdVar != null) {
            this.a.a(bdVar);
            this.a.h().d(bdVar.e());
            this.a.a = 1;
            eVar2 = this.a.b;
            eVar2.a(true);
            return;
        }
        if (this.b != null && this.d) {
            this.a.a(this.b.f());
        } else {
            this.a.a((String) null);
        }
        this.a.a = 1;
        eVar = this.a.b;
        eVar.a(false);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        this.c = true;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.o = null;
        super.cancel(true);
        eVar = this.a.b;
        eVar.a(false);
    }
}
