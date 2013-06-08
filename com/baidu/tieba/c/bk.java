package com.baidu.tieba.c;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.lib.a.a {
    final /* synthetic */ bi a;
    private com.baidu.tieba.d.t b;
    private volatile boolean c;
    private boolean d;

    private bk(bi biVar) {
        this.a = biVar;
        this.b = null;
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bk(bi biVar, bk bkVar) {
        this(biVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.a.be a(Boolean... boolArr) {
        com.baidu.tieba.a.be beVar;
        Exception e;
        String e2;
        boolean booleanValue = boolArr[0].booleanValue();
        this.d = boolArr[1].booleanValue();
        try {
            if (this.a.e() && booleanValue && (e2 = com.baidu.tieba.d.k.e()) != null) {
                com.baidu.tieba.a.be beVar2 = new com.baidu.tieba.a.be();
                beVar2.e(e2);
                c(beVar2);
                this.d = false;
            }
            if (!this.c && this.a.d() != null) {
                this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/u/user/profile");
                this.b.a("uid", this.a.d());
                String i = this.b.i();
                if (this.b.b()) {
                    beVar = new com.baidu.tieba.a.be();
                    try {
                        JSONObject optJSONObject = new JSONObject(i).optJSONObject("user");
                        beVar.a(optJSONObject);
                        if (this.a.e()) {
                            com.baidu.tieba.d.k.g(optJSONObject.toString());
                            return beVar;
                        }
                        return beVar;
                    } catch (Exception e3) {
                        e = e3;
                        com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                        return beVar;
                    }
                }
            }
            return null;
        } catch (Exception e4) {
            beVar = null;
            e = e4;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: a */
    public void b(com.baidu.tieba.a.be... beVarArr) {
        com.baidu.adp.a.e eVar;
        boolean z = false;
        super.b((Object[]) beVarArr);
        com.baidu.tieba.a.be beVar = beVarArr[0];
        if (beVar != null) {
            this.a.a(beVar);
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
    public void a(com.baidu.tieba.a.be beVar) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) beVar);
        this.a.p = null;
        if (beVar != null) {
            this.a.a(beVar);
            this.a.h().d(beVar.e());
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
        this.a.p = null;
        super.cancel(true);
        eVar = this.a.b;
        eVar.a(false);
    }
}
