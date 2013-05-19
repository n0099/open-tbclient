package com.baidu.tieba.c;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.a.a {
    final /* synthetic */ w a;
    private int b;
    private com.baidu.tieba.d.t c = null;

    public z(w wVar, int i) {
        this.a = wVar;
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
        JSONObject jSONObject;
        Exception e;
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
            String i2 = this.c.i();
            jSONObject = new JSONObject(i2);
            try {
                if (this.c.b()) {
                    this.a.a(i2);
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
        this.a.l = null;
        axVar = this.a.n;
        if (axVar != null) {
            y yVar = new y(this.a);
            if (this.c != null) {
                yVar.a = true;
                yVar.b = this.c.c();
                yVar.c = this.c.d();
                yVar.d = this.c.f();
                yVar.e = this.c.a();
            }
            axVar2 = this.a.n;
            axVar2.a(this.b, jSONObject, yVar);
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
