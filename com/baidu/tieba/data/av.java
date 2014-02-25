package com.baidu.tieba.data;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {
    private ForumData a;
    private int e;
    private int g;
    private AntiData i;
    private az j;
    private int f = 10;
    private int h = -1;
    private boolean k = false;
    private aq b = null;
    private ArrayList<aq> c = new ArrayList<>();
    private int d = 1;

    public aq a() {
        return this.b;
    }

    public void a(aq aqVar) {
        this.b = aqVar;
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

    public void a(av avVar, boolean z) {
        if (avVar != null) {
            a(avVar.i());
            a(avVar.g());
            a(avVar.h());
            d(avVar.f());
            a(avVar.m());
            c(avVar.e());
            b(avVar.d());
            this.c.size();
            this.c.addAll(0, avVar.c());
        }
    }

    public void b(av avVar, boolean z) {
        if (avVar != null) {
            a(avVar.i());
            e(avVar.g());
            a(avVar.h());
            d(avVar.f());
            a(avVar.m());
            c(avVar.e());
            b(avVar.d());
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(avVar.c());
        }
    }

    public ArrayList<aq> c() {
        return this.c;
    }

    public void a(ArrayList<aq> arrayList) {
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
        this.a = forumData;
    }

    public ForumData h() {
        return this.a;
    }

    public void a(AntiData antiData) {
        this.i = antiData;
    }

    public AntiData i() {
        return this.i;
    }

    public void a(az azVar) {
        this.j = azVar;
    }

    public boolean j() {
        return (this.j == null || this.b == null || this.j.j() == null || this.j.j().getUserId() == null || this.b.g() == null || this.b.g().getUserId() == null || !this.j.j().getUserId().equals(this.b.g().getUserId())) ? false : true;
    }

    public boolean k() {
        return this.k;
    }

    public boolean l() {
        return this.g < this.d && this.g * this.f < 200;
    }

    public az m() {
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
            az azVar = new az();
            azVar.a(optJSONObject3);
            a(azVar);
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            a(forumData);
            aq aqVar = new aq();
            aqVar.a(optJSONObject, context);
            a(aqVar);
            int length = optJSONArray.length();
            ArrayList<aq> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                aq aqVar2 = new aq();
                aqVar2.a(jSONObject2, context);
                arrayList.add(aqVar2);
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
            com.baidu.adp.lib.util.f.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        this.k = z;
    }
}
