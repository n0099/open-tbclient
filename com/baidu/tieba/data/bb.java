package com.baidu.tieba.data;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private ForumData f1148a;
    private int e;
    private int g;
    private AntiData h;
    private bf i;
    private int f = 10;
    private boolean j = false;
    private as b = null;
    private ArrayList<as> c = new ArrayList<>();
    private int d = 1;

    public as a() {
        return this.b;
    }

    public void a(as asVar) {
        this.b = asVar;
    }

    public void a(bb bbVar, boolean z) {
        if (bbVar != null) {
            a(bbVar.h());
            d(bbVar.f());
            a(bbVar.g());
            c(bbVar.e());
            a(bbVar.l());
            b(bbVar.d());
            a(bbVar.c());
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(bbVar.b());
        }
    }

    public ArrayList<as> b() {
        return this.c;
    }

    public void a(ArrayList<as> arrayList) {
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

    public void a(ForumData forumData) {
        this.f1148a = forumData;
    }

    public ForumData g() {
        return this.f1148a;
    }

    public void a(AntiData antiData) {
        this.h = antiData;
    }

    public AntiData h() {
        return this.h;
    }

    public void a(bf bfVar) {
        this.i = bfVar;
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

    public bf l() {
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
            bf bfVar = new bf();
            bfVar.a(optJSONObject3);
            a(bfVar);
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            a(forumData);
            as asVar = new as();
            asVar.a(optJSONObject, context);
            a(asVar);
            int length = optJSONArray.length();
            ArrayList<as> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                as asVar2 = new as();
                asVar2.a(jSONObject2, context);
                arrayList.add(asVar2);
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
            com.baidu.tieba.util.be.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        this.j = z;
    }
}
