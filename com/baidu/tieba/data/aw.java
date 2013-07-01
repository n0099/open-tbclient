package com.baidu.tieba.data;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private r f773a;
    private int e;
    private int g;
    private AntiData h;
    private ba i;
    private int f = 10;
    private boolean j = false;
    private an b = null;
    private ArrayList c = new ArrayList();
    private int d = 1;

    public an a() {
        return this.b;
    }

    public void a(an anVar) {
        this.b = anVar;
    }

    public void a(aw awVar, boolean z) {
        if (awVar != null) {
            a(awVar.h());
            d(awVar.f());
            a(awVar.g());
            c(awVar.e());
            a(awVar.l());
            b(awVar.d());
            a(awVar.c());
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(awVar.b());
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

    public void a(r rVar) {
        this.f773a = rVar;
    }

    public r g() {
        return this.f773a;
    }

    public void a(AntiData antiData) {
        this.h = antiData;
    }

    public AntiData h() {
        return this.h;
    }

    public void a(ba baVar) {
        this.i = baVar;
    }

    public boolean i() {
        return (this.i == null || this.b == null || this.i.g() == null || this.i.g().getId() == null || this.b.h() == null || this.b.h().getId() == null || !this.i.g().getId().equals(this.b.h().getId())) ? false : true;
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.g < this.d && this.g * this.f < 200;
    }

    public ba l() {
        return this.i;
    }

    public void a(String str, Context context) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("post");
            JSONArray optJSONArray = jSONObject.optJSONArray("subpost_list");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("thread");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("anti");
            AntiData antiData = new AntiData();
            antiData.parserJson(optJSONObject4);
            a(antiData);
            ba baVar = new ba();
            baVar.a(optJSONObject3);
            a(baVar);
            r rVar = new r();
            rVar.a(optJSONObject2);
            a(rVar);
            an anVar = new an();
            anVar.a(optJSONObject, context);
            a(anVar);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                an anVar2 = new an();
                anVar2.a(jSONObject2, context);
                arrayList.add(anVar2);
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
            com.baidu.tieba.util.z.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        this.j = z;
    }
}
