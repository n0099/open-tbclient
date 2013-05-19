package com.baidu.tieba.c;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.lib.a.a {
    final /* synthetic */ w a;
    private int b;
    private com.baidu.tieba.d.t c = null;

    public x(w wVar, int i) {
        this.a = wVar;
        this.b = 0;
        this.b = i;
        if (this.b < 1) {
            this.b = 1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public JSONObject a(Object... objArr) {
        JSONObject jSONObject;
        Exception e;
        String str;
        String str2;
        String str3;
        try {
            this.c = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/frs/photolist");
            str = this.a.i;
            if (str != null) {
                com.baidu.tieba.d.t tVar = this.c;
                str3 = this.a.i;
                tVar.a("st_type", str3);
            }
            com.baidu.tieba.d.t tVar2 = this.c;
            str2 = this.a.j;
            tVar2.a("kw", str2);
            this.c.a("bs", String.valueOf(this.b));
            this.c.a("be", String.valueOf((this.b + 240) - 1));
            this.c.a("an", String.valueOf(30));
            String i = this.c.i();
            jSONObject = new JSONObject(i);
            try {
                if (this.c.b()) {
                    this.a.a(i);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return jSONObject;
            }
        } catch (Exception e3) {
            jSONObject = null;
            e = e3;
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.a((Object) jSONObject);
        this.a.k = null;
        axVar = this.a.m;
        if (axVar != null) {
            y yVar = new y(this.a);
            if (this.c != null) {
                yVar.a = true;
                yVar.b = this.c.c();
                yVar.c = this.c.d();
                yVar.d = this.c.f();
                yVar.e = this.c.a();
            }
            axVar2 = this.a.m;
            axVar2.a(this.b, jSONObject, yVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.b();
        axVar = this.a.m;
        if (axVar != null) {
            axVar2 = this.a.m;
            axVar2.a(0);
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        this.a.k = null;
    }
}
