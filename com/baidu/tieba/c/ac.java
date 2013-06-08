package com.baidu.tieba.c;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.lib.a.a {
    final /* synthetic */ z a;
    private int b;
    private com.baidu.tieba.d.t c = null;

    public ac(z zVar, int i) {
        this.a = zVar;
        this.b = 0;
        this.b = i;
        if (this.b < 0) {
            this.b = 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public JSONObject a(Object... objArr) {
        String str;
        try {
            this.c = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/frs/photo");
            StringBuilder sb = new StringBuilder();
            int size = this.a.c().size();
            for (int i = this.b; i < size && i < this.b + 30; i++) {
                sb.append((String) this.a.c().get(i));
                sb.append(",");
            }
            int length = sb.length();
            if (length > 1 && sb.charAt(length - 1) == ',') {
                sb.deleteCharAt(length - 1);
            }
            this.c.a("alb_ids", sb.toString());
            com.baidu.tieba.d.t tVar = this.c;
            str = this.a.j;
            tVar.a("kw", str);
            return new JSONObject(this.c.i());
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(JSONObject jSONObject) {
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.a((Object) jSONObject);
        this.a.l = null;
        axVar = this.a.n;
        if (axVar != null) {
            ab abVar = new ab(this.a);
            if (this.c != null) {
                abVar.a = true;
                abVar.b = this.c.c();
                abVar.c = this.c.d();
                abVar.d = this.c.f();
                abVar.e = this.c.a();
            }
            axVar2 = this.a.n;
            axVar2.a(this.b, jSONObject, abVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        com.baidu.tieba.frs.ax axVar;
        com.baidu.tieba.frs.ax axVar2;
        super.b();
        axVar = this.a.n;
        if (axVar != null) {
            axVar2 = this.a.n;
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
        this.a.l = null;
    }
}
