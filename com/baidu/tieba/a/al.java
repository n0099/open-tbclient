package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    private q a = new q();
    private av b = new av();
    private ArrayList c = new ArrayList();
    private ak d = new ak();
    private b e = new b();
    private int g = 0;
    private boolean f = false;

    public q a() {
        return this.a;
    }

    public void a(q qVar) {
        this.a = qVar;
    }

    public av b() {
        return this.b;
    }

    public void a(av avVar) {
        this.b = avVar;
    }

    public ArrayList c() {
        return this.c;
    }

    public ak d() {
        return this.d;
    }

    public void a(ak akVar) {
        this.d = akVar;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public b e() {
        return this.e;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.af.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a.a(jSONObject.optJSONObject("forum"));
                this.b.a(jSONObject.optJSONObject("thread"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        an anVar = new an();
                        anVar.a(optJSONArray.optJSONObject(i));
                        this.c.add(anVar);
                    }
                }
                this.d.a(jSONObject.optJSONObject("page"));
                this.e.a(jSONObject.optJSONObject("anti"));
                this.f = jSONObject.optInt("has_floor") == 1;
                this.g = jSONObject.optJSONObject("user").optInt("is_manager", 0);
            } catch (Exception e) {
                com.baidu.tieba.c.af.b("PbData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public boolean f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }
}
