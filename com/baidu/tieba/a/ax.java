package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ax {
    private s a;
    private int e;
    private int g;
    private b h;
    private bb i;
    private int f = 10;
    private boolean j = false;
    private aq b = null;
    private ArrayList c = new ArrayList();
    private int d = 1;

    public aq a() {
        return this.b;
    }

    public void a(aq aqVar) {
        this.b = aqVar;
    }

    public void a(ax axVar, boolean z) {
        if (axVar != null) {
            a(axVar.h());
            d(axVar.f());
            a(axVar.g());
            c(axVar.e());
            a(axVar.l());
            b(axVar.d());
            a(axVar.c());
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(axVar.b());
        }
    }

    public ArrayList b() {
        return this.c;
    }

    public void a(ArrayList arrayList) {
        this.c = arrayList;
    }

    public int c() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int d() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public int e() {
        return this.f;
    }

    public void c(int i) {
        if (i != 0) {
            this.f = i;
        }
    }

    public int f() {
        return this.g;
    }

    public void d(int i) {
        this.g = i;
    }

    public void a(s sVar) {
        this.a = sVar;
    }

    public s g() {
        return this.a;
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public b h() {
        return this.h;
    }

    public void a(bb bbVar) {
        this.i = bbVar;
    }

    public boolean i() {
        return (this.i == null || this.b == null || this.i.g() == null || this.i.g().a() == null || this.b.h() == null || this.b.h().a() == null || !this.i.g().a().equals(this.b.h().a())) ? false : true;
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.g < this.d && this.g * this.f < 200;
    }

    public bb l() {
        return this.i;
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("post");
            JSONArray optJSONArray = jSONObject.optJSONArray("subpost_list");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("thread");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("anti");
            b bVar = new b();
            bVar.a(optJSONObject4);
            a(bVar);
            bb bbVar = new bb();
            bbVar.a(optJSONObject3);
            a(bbVar);
            s sVar = new s();
            sVar.a(optJSONObject2);
            a(sVar);
            aq aqVar = new aq();
            aqVar.a(optJSONObject);
            a(aqVar);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                aq aqVar2 = new aq();
                aqVar2.a(jSONObject2);
                arrayList.add(aqVar2);
            }
            a(arrayList);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("page");
            int optInt = optJSONObject5.optInt("total_page");
            int optInt2 = optJSONObject5.optInt("page_size", 10);
            int optInt3 = optJSONObject5.optInt("current_page");
            int optInt4 = optJSONObject5.optInt("total_count");
            d(optInt3);
            c(optInt2);
            b(optInt4);
            a(optInt);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        this.j = z;
    }
}
