package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.tieba.util.bg;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private ForumData f1177a;
    private int e;
    private int g;
    private AntiData i;
    private ba j;
    private int f = 10;
    private int h = -1;
    private boolean k = false;
    private as b = null;
    private ArrayList<as> c = new ArrayList<>();
    private int d = 1;

    public as a() {
        return this.b;
    }

    public void a(as asVar) {
        this.b = asVar;
    }

    public void a(int i) {
        this.h = i;
    }

    public int b() {
        if (this.h == -1) {
            this.h = this.g;
        }
        return this.h;
    }

    public void a(aw awVar, boolean z) {
        if (awVar != null) {
            a(awVar.i());
            a(awVar.g());
            a(awVar.h());
            d(awVar.f());
            a(awVar.m());
            c(awVar.e());
            b(awVar.d());
            this.c.size();
            this.c.addAll(0, awVar.c());
        }
    }

    public void b(aw awVar, boolean z) {
        if (awVar != null) {
            a(awVar.i());
            e(awVar.g());
            a(awVar.h());
            d(awVar.f());
            a(awVar.m());
            c(awVar.e());
            b(awVar.d());
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(awVar.c());
        }
    }

    public ArrayList<as> c() {
        return this.c;
    }

    public void a(ArrayList<as> arrayList) {
        this.c = arrayList;
    }

    public int d() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public int e() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int f() {
        return this.f;
    }

    public void d(int i) {
        if (i != 0) {
            this.f = i;
        }
    }

    public int g() {
        return this.g;
    }

    public void e(int i) {
        this.g = i;
    }

    public void a(ForumData forumData) {
        this.f1177a = forumData;
    }

    public ForumData h() {
        return this.f1177a;
    }

    public void a(AntiData antiData) {
        this.i = antiData;
    }

    public AntiData i() {
        return this.i;
    }

    public void a(ba baVar) {
        this.j = baVar;
    }

    public boolean j() {
        return (this.j == null || this.b == null || this.j.j() == null || this.j.j().getId() == null || this.b.g() == null || this.b.g().getId() == null || !this.j.j().getId().equals(this.b.g().getId())) ? false : true;
    }

    public boolean k() {
        return this.k;
    }

    public boolean l() {
        return this.g < this.d && this.g * this.f < 200;
    }

    public ba m() {
        return this.j;
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
            e(optInt3);
            d(optInt2);
            c(optInt4);
            b(optInt);
        } catch (Exception e) {
            bg.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        this.k = z;
    }
}
