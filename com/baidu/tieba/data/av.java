package com.baidu.tieba.data;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class av {
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

    public final aq a() {
        return this.b;
    }

    public final void a(aq aqVar) {
        this.b = aqVar;
    }

    public final int b() {
        if (this.h == -1) {
            this.h = this.g;
        }
        return this.h;
    }

    public final void a(av avVar) {
        if (avVar != null) {
            this.i = avVar.i;
            this.h = avVar.g;
            this.a = avVar.a;
            c(avVar.f);
            this.j = avVar.j;
            this.e = avVar.e;
            this.d = avVar.d;
            this.c.size();
            this.c.addAll(0, avVar.c);
        }
    }

    public final void a(av avVar, boolean z) {
        if (avVar != null) {
            this.i = avVar.i;
            this.g = avVar.g;
            this.a = avVar.a;
            c(avVar.f);
            this.j = avVar.j;
            this.e = avVar.e;
            this.d = avVar.d;
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(avVar.c);
        }
    }

    public final ArrayList<aq> c() {
        return this.c;
    }

    public final void a(ArrayList<aq> arrayList) {
        this.c = arrayList;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final int d() {
        return this.e;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final int e() {
        return this.f;
    }

    public final void c(int i) {
        if (i != 0) {
            this.f = i;
        }
    }

    public final int f() {
        return this.g;
    }

    public final void d(int i) {
        this.g = i;
    }

    public final void a(ForumData forumData) {
        this.a = forumData;
    }

    public final ForumData g() {
        return this.a;
    }

    public final void a(AntiData antiData) {
        this.i = antiData;
    }

    public final AntiData h() {
        return this.i;
    }

    public final void a(az azVar) {
        this.j = azVar;
    }

    public final boolean i() {
        return (this.j == null || this.b == null || this.j.i() == null || this.j.i().getUserId() == null || this.b.g() == null || this.b.g().getUserId() == null || !this.j.i().getUserId().equals(this.b.g().getUserId())) ? false : true;
    }

    public final boolean j() {
        return this.k;
    }

    public final boolean k() {
        return this.g < this.d && this.g * this.f < 200;
    }

    public final az l() {
        return this.j;
    }

    public final void a(String str, Context context) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("post");
            JSONArray optJSONArray = jSONObject.optJSONArray("subpost_list");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("thread");
            JSONObject optJSONObject4 = jSONObject.optJSONObject("anti");
            AntiData antiData = new AntiData();
            antiData.parserJson(optJSONObject4);
            this.i = antiData;
            az azVar = new az();
            azVar.a(optJSONObject3);
            this.j = azVar;
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            this.a = forumData;
            aq aqVar = new aq();
            aqVar.a(optJSONObject, context);
            this.b = aqVar;
            int length = optJSONArray.length();
            ArrayList<aq> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                aq aqVar2 = new aq();
                aqVar2.a(jSONObject2, context);
                arrayList.add(aqVar2);
            }
            this.c = arrayList;
            JSONObject optJSONObject5 = jSONObject.optJSONObject("page");
            int optInt = optJSONObject5.optInt("total_page");
            int optInt2 = optJSONObject5.optInt("page_size", 10);
            int optInt3 = optJSONObject5.optInt("current_page");
            int optInt4 = optJSONObject5.optInt("total_count");
            this.g = optInt3;
            c(optInt2);
            this.e = optInt4;
            this.d = optInt;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("SubPbModel", "parseJson", "error = " + e.getMessage());
        }
    }

    public final void a(boolean z) {
        this.k = z;
    }
}
