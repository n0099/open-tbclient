package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class an {
    private ForumData a;
    private int e;
    private int g;
    private AntiData i;
    private com.baidu.tbadk.core.data.o j;
    private int f = 10;
    private int h = -1;
    private boolean k = false;
    private ai b = null;
    private ArrayList<ai> c = new ArrayList<>();
    private int d = 1;

    public final ai a() {
        return this.b;
    }

    public final void a(ai aiVar) {
        this.b = aiVar;
    }

    public final int b() {
        if (this.h == -1) {
            this.h = this.g;
        }
        return this.h;
    }

    public final void a(an anVar) {
        if (anVar != null) {
            this.i = anVar.i;
            this.h = anVar.g;
            this.a = anVar.a;
            c(anVar.f);
            this.j = anVar.j;
            this.e = anVar.e;
            this.d = anVar.d;
            this.c.addAll(0, anVar.c);
        }
    }

    public final void a(an anVar, boolean z) {
        if (anVar != null) {
            this.i = anVar.i;
            this.g = anVar.g;
            this.a = anVar.a;
            c(anVar.f);
            this.j = anVar.j;
            this.e = anVar.e;
            this.d = anVar.d;
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(anVar.c);
        }
    }

    public final ArrayList<ai> c() {
        return this.c;
    }

    public final void a(ArrayList<ai> arrayList) {
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

    public final void a(com.baidu.tbadk.core.data.o oVar) {
        this.j = oVar;
    }

    public final boolean i() {
        return (this.j == null || this.b == null || this.j.t() == null || this.j.t().getUserId() == null || this.b.g() == null || this.b.g().getUserId() == null || !this.j.t().getUserId().equals(this.b.g().getUserId())) ? false : true;
    }

    public final boolean j() {
        return this.k;
    }

    public final boolean k() {
        return this.g < this.d && this.g * this.f < 200;
    }

    public final com.baidu.tbadk.core.data.o l() {
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
            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
            oVar.a(optJSONObject3);
            this.j = oVar;
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            this.a = forumData;
            ai aiVar = new ai();
            aiVar.a(optJSONObject, context);
            this.b = aiVar;
            int length = optJSONArray.length();
            ArrayList<ai> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                ai aiVar2 = new ai();
                aiVar2.a(jSONObject2, context);
                arrayList.add(aiVar2);
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
            com.baidu.adp.lib.util.f.b("SubPbData", "parseJson", "error = " + e.getMessage());
        }
    }

    public final void a(boolean z) {
        this.k = z;
    }
}
