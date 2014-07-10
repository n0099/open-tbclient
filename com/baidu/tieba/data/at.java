package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class at {
    private ForumData a;
    private int e;
    private int g;
    private AntiData i;
    private com.baidu.tbadk.core.data.m j;
    private int f = 10;
    private int h = -1;
    private boolean k = false;
    private am b = null;
    private ArrayList<am> c = new ArrayList<>();
    private int d = 1;

    public am a() {
        return this.b;
    }

    public void a(am amVar) {
        this.b = amVar;
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

    public void a(at atVar, boolean z) {
        if (atVar != null) {
            a(atVar.i());
            a(atVar.g());
            a(atVar.h());
            d(atVar.f());
            a(atVar.m());
            c(atVar.e());
            b(atVar.d());
            this.c.addAll(0, atVar.c());
        }
    }

    public void b(at atVar, boolean z) {
        if (atVar != null) {
            a(atVar.i());
            e(atVar.g());
            a(atVar.h());
            d(atVar.f());
            a(atVar.m());
            c(atVar.e());
            b(atVar.d());
            int size = this.c.size();
            if (z && size % this.f != 0) {
                for (int i = 0; i < size % this.f; i++) {
                    this.c.remove(this.c.size() - 1);
                }
            }
            this.c.addAll(atVar.c());
        }
    }

    public ArrayList<am> c() {
        return this.c;
    }

    public void a(ArrayList<am> arrayList) {
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

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.j = mVar;
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

    public com.baidu.tbadk.core.data.m m() {
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
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            mVar.a(optJSONObject3);
            a(mVar);
            ForumData forumData = new ForumData();
            forumData.parserJson(optJSONObject2);
            a(forumData);
            am amVar = new am();
            amVar.a(optJSONObject, context);
            a(amVar);
            int length = optJSONArray.length();
            ArrayList<am> arrayList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                am amVar2 = new am();
                amVar2.a(jSONObject2, context);
                arrayList.add(amVar2);
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
            BdLog.detailException(e);
        }
    }

    public void a(boolean z) {
        this.k = z;
    }
}
