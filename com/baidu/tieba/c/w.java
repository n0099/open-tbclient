package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends com.baidu.adp.lib.a.a {
    ArrayList a;
    v b;
    final /* synthetic */ s c;
    private com.baidu.tieba.d.t d = null;
    private String e;
    private int f;

    public w(s sVar, String str, ArrayList arrayList, int i) {
        this.c = sVar;
        this.e = null;
        this.f = 3;
        this.a = null;
        this.b = new v(sVar);
        this.e = str;
        this.a = arrayList;
        this.f = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        com.baidu.tieba.frs.ac acVar;
        com.baidu.tieba.frs.ac acVar2;
        acVar = this.c.f;
        if (acVar != null) {
            acVar2 = this.c.f;
            acVar2.a(this.f);
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
            this.d = new com.baidu.tieba.d.t(this.e);
            this.d.a(this.a);
            String i = this.d.i();
            jSONObject = new JSONObject(i);
            try {
                if (this.d.b()) {
                    this.c.a(i);
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
        if (this.d != null) {
            this.b.a = true;
            this.b.b = this.d.c();
            this.b.c = this.d.d();
            this.b.d = this.d.f();
            this.b.e = this.d.a();
        }
        acVar = this.c.f;
        if (acVar != null) {
            acVar2 = this.c.f;
            acVar2.a(this.f, jSONObject, this.b);
        }
        this.c.i = null;
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
        super.cancel(true);
        if (this.d != null) {
            this.d.g();
        }
        acVar = this.c.f;
        if (acVar != null) {
            acVar2 = this.c.f;
            acVar2.a(this.f, null, null);
        }
    }
}
