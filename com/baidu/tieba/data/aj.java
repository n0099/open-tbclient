package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.zeus.Headers;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private an c;
    private r a = new r();
    private ba b = new ba();
    private ArrayList d = new ArrayList();
    private ai e = new ai();
    private AntiData f = new AntiData();
    private ad g = new ad();
    private int i = 0;
    private boolean h = false;

    public r a() {
        return this.a;
    }

    public void a(r rVar) {
        this.a = rVar;
    }

    public ba b() {
        return this.b;
    }

    public void a(ba baVar) {
        this.b = baVar;
    }

    public ad c() {
        return this.g;
    }

    public ArrayList d() {
        return this.d;
    }

    public ai e() {
        return this.e;
    }

    public void a(ai aiVar, int i) {
        this.e.c(aiVar.d());
        this.e.b(aiVar.b());
        this.e.a(aiVar.a());
        this.e.d(aiVar.e());
        if (i == 0) {
            this.e = aiVar;
        } else if (i == 1) {
            this.e.e(aiVar.f());
        } else if (i == 2) {
            this.e.f(aiVar.g());
        }
    }

    public void a(AntiData antiData) {
        this.f = antiData;
    }

    public AntiData f() {
        return this.f;
    }

    public boolean g() {
        return this.b.k() != 0;
    }

    public void a(boolean z) {
        if (this.b != null) {
            if (z) {
                this.b.c(1);
            } else {
                this.b.c(0);
            }
        }
    }

    public String h() {
        if (this.b != null) {
            return this.b.l();
        }
        return null;
    }

    public void a(String str) {
        if (this.b != null) {
            this.b.a(str);
        }
    }

    public void i() {
        this.c = (an) this.d.get(0);
    }

    public an j() {
        return this.c;
    }

    public void a(String str, Context context) {
        try {
            a(new JSONObject(str), context);
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, (Context) null);
    }

    public void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                this.a.a(jSONObject.optJSONObject("forum"));
                this.b.a(jSONObject.optJSONObject("thread"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        an anVar = new an();
                        anVar.a(optJSONArray.optJSONObject(i), context);
                        this.d.add(anVar);
                    }
                }
                this.e.a(jSONObject.optJSONObject("page"));
                this.f.parserJson(jSONObject.optJSONObject("anti"));
                this.g.a(jSONObject.optJSONObject(Headers.LOCATION));
                this.h = jSONObject.optInt("has_floor") == 1;
                this.i = jSONObject.optJSONObject("user").optInt("is_manager", 0);
            } catch (Exception e) {
                com.baidu.tieba.util.z.b("PbData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public boolean k() {
        return this.h;
    }

    public int l() {
        return this.i;
    }
}
