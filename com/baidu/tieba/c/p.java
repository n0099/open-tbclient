package com.baidu.tieba.c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private com.baidu.tieba.a.b c;
    private com.baidu.tieba.frs.ac f = null;
    private com.baidu.tieba.frs.ab g = null;
    private boolean h = false;
    private t i = null;
    private q j = null;
    private com.baidu.tieba.a.s a = new com.baidu.tieba.a.s();
    private ArrayList b = new ArrayList();
    private com.baidu.tieba.a.ak d = new com.baidu.tieba.a.ak();
    private com.baidu.tieba.a.u e = new com.baidu.tieba.a.u();

    public p() {
        a(new com.baidu.tieba.a.b());
    }

    public void a(com.baidu.tieba.a.ac acVar) {
        this.a.d(acVar.d());
        this.a.e(acVar.e());
        this.a.a(acVar.b());
        this.a.b(acVar.a());
        this.a.a(acVar.c());
    }

    public void a(com.baidu.tieba.a.aw awVar) {
        this.a.a(awVar);
    }

    public com.baidu.tieba.a.s a() {
        return this.a;
    }

    public ArrayList b() {
        return this.b;
    }

    public void a(com.baidu.tieba.a.b bVar) {
        this.c = bVar;
    }

    public com.baidu.tieba.a.b c() {
        return this.c;
    }

    public com.baidu.tieba.a.ak d() {
        return this.d;
    }

    public com.baidu.tieba.a.u e() {
        return this.e;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public boolean f() {
        return this.h;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.a.a(jSONObject.optJSONObject("forum"));
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    com.baidu.tieba.a.bb bbVar = new com.baidu.tieba.a.bb();
                    bbVar.a(optJSONArray.optJSONObject(i));
                    bbVar.o();
                    this.b.add(bbVar);
                }
            }
            this.c.a(jSONObject.optJSONObject("anti"));
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("frs_star"));
        } catch (Exception e) {
        }
    }

    public void a(String str, ArrayList arrayList, int i) {
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
        this.i = new t(this, str, arrayList, i);
        this.i.setPriority(3);
        this.i.execute(str, arrayList);
    }

    public void b(String str) {
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        com.baidu.tieba.a.s a = a();
        this.j = new q(this, a.a(), a.b(), str);
        this.j.setPriority(2);
        this.j.execute(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/user/fansno");
    }

    public void g() {
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
    }

    public void a(r rVar) {
        com.baidu.tieba.a.ac acVar = new com.baidu.tieba.a.ac();
        acVar.b(1);
        acVar.a(rVar.d);
        acVar.b(rVar.e);
        acVar.e(rVar.f);
        acVar.f(rVar.g);
        a(acVar);
    }

    public void a(com.baidu.tieba.frs.ac acVar) {
        this.f = acVar;
    }

    public void a(com.baidu.tieba.frs.ab abVar) {
        this.g = abVar;
    }
}
