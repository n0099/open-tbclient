package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.lib.a.a {
    ArrayList a;
    final /* synthetic */ p b;
    private com.baidu.tieba.d.t c = null;
    private String d;
    private int e;

    public t(p pVar, String str, ArrayList arrayList, int i) {
        this.b = pVar;
        this.d = null;
        this.e = 3;
        this.a = null;
        this.d = str;
        this.a = arrayList;
        this.e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        acVar = this.b.f;
        if (acVar != null) {
            acVar2 = this.b.f;
            acVar2.a(this.e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public JSONObject a(Object... objArr) {
        JSONObject jSONObject;
        Exception e;
        try {
            this.c = new com.baidu.tieba.d.t(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            jSONObject = new JSONObject(i);
            try {
                if (this.c.b()) {
                    this.b.a(i);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.d.ae.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
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
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        s sVar = new s(this.b);
        if (this.c != null) {
            sVar.a = true;
            sVar.b = this.c.c();
            sVar.c = this.c.d();
            sVar.d = this.c.f();
            sVar.e = this.c.a();
        }
        acVar = this.b.f;
        if (acVar != null) {
            acVar2 = this.b.f;
            acVar2.a(this.e, jSONObject, sVar);
        }
        this.b.i = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        if (this.c != null) {
            this.c.g();
        }
        acVar = this.b.f;
        if (acVar != null) {
            acVar2 = this.b.f;
            acVar2.a(this.e, null, null);
        }
        super.cancel(true);
    }
}
