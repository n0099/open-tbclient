package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private ForumData a;
    private int e;
    private int g;
    private AntiData i;
    private com.baidu.tbadk.core.data.n j;
    private int f = 10;
    private int h = -1;
    private boolean k = false;
    private ai b = null;
    private ArrayList<ai> c = new ArrayList<>();
    private int d = 1;

    public ai a() {
        return this.b;
    }

    public void a(ai aiVar) {
        this.b = aiVar;
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

    public void a(ap apVar, boolean z) {
        if (apVar != null) {
            a(apVar.i());
            a(apVar.g());
            a(apVar.h());
            d(apVar.f());
            a(apVar.m());
            c(apVar.e());
            b(apVar.d());
            this.c.addAll(0, apVar.c());
        }
    }

    public void b(ap apVar, boolean z) {
        if (apVar != null) {
            a(apVar.i());
            e(apVar.g());
            a(apVar.h());
            d(apVar.f());
            a(apVar.m());
            c(apVar.e());
            b(apVar.d());
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(apVar.c());
        }
    }

    public ArrayList<ai> c() {
        return this.c;
    }

    public void a(ArrayList<ai> arrayList) {
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

    public void a(com.baidu.tbadk.core.data.n nVar) {
        this.j = nVar;
    }

    public boolean j() {
        return (this.j == null || this.b == null || this.j.y() == null || this.j.y().getUserId() == null || this.b.o() == null || this.b.o().getUserId() == null || !this.j.y().getUserId().equals(this.b.o().getUserId())) ? false : true;
    }

    public boolean k() {
        return this.k;
    }

    public boolean l() {
        return this.g < this.d && this.g * this.f < 200;
    }

    public com.baidu.tbadk.core.data.n m() {
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
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            nVar.a(optJSONObject3);
            a(nVar);
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            a(forumData);
            ai aiVar = new ai();
            aiVar.a(optJSONObject, context);
            a(aiVar);
            int length = optJSONArray.length();
            ArrayList<ai> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                ai aiVar2 = new ai();
                aiVar2.a(jSONObject2, context);
                arrayList.add(aiVar2);
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
            BdLog.e("SubPbData", "parseJson", "error = " + e.getMessage());
        }
    }

    public void a(boolean z) {
        this.k = z;
    }
}
