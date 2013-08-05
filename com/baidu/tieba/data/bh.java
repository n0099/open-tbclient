package com.baidu.tieba.data;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bh {

    /* renamed from: a  reason: collision with root package name */
    private v f998a;
    private int e;
    private int g;
    private AntiData h;
    private bm i;
    private int f = 10;
    private boolean j = false;
    private aw b = null;
    private ArrayList c = new ArrayList();
    private int d = 1;

    public aw a() {
        return this.b;
    }

    public void a(aw awVar) {
        this.b = awVar;
    }

    public void a(bh bhVar, boolean z) {
        if (bhVar != null) {
            a(bhVar.h());
            d(bhVar.f());
            a(bhVar.g());
            c(bhVar.e());
            a(bhVar.l());
            b(bhVar.d());
            a(bhVar.c());
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(bhVar.b());
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

    public void a(v vVar) {
        this.f998a = vVar;
    }

    public v g() {
        return this.f998a;
    }

    public void a(AntiData antiData) {
        this.h = antiData;
    }

    public AntiData h() {
        return this.h;
    }

    public void a(bm bmVar) {
        this.i = bmVar;
    }

    public boolean i() {
        return (this.i == null || this.b == null || this.i.g() == null || this.i.g().getId() == null || this.b.g() == null || this.b.g().getId() == null || !this.i.g().getId().equals(this.b.g().getId())) ? false : true;
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.g < this.d && this.g * this.f < 200;
    }

    public bm l() {
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
            bm bmVar = new bm();
            bmVar.a(optJSONObject3);
            a(bmVar);
            v vVar = new v();
            vVar.a(optJSONObject2);
            a(vVar);
            aw awVar = new aw();
            awVar.a(optJSONObject, context);
            a(awVar);
            int length = optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                aw awVar2 = new aw();
                awVar2.a(jSONObject2, context);
                arrayList.add(awVar2);
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
            com.baidu.tieba.util.aj.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        this.j = z;
    }
}
