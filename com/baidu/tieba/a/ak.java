package com.baidu.tieba.a;

import com.baidu.zeus.Headers;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private an c;
    private q a = new q();
    private ax b = new ax();
    private ArrayList d = new ArrayList();
    private aj e = new aj();
    private b f = new b();
    private ac g = new ac();
    private int i = 0;
    private boolean h = false;

    public q a() {
        return this.a;
    }

    public void a(q qVar) {
        this.a = qVar;
    }

    public ax b() {
        return this.b;
    }

    public void a(ax axVar) {
        this.b = axVar;
    }

    public ac c() {
        return this.g;
    }

    public ArrayList d() {
        return this.d;
    }

    public aj e() {
        return this.e;
    }

    public void a(aj ajVar) {
        this.e = ajVar;
    }

    public void a(b bVar) {
        this.f = bVar;
    }

    public b f() {
        return this.f;
    }

    public boolean g() {
        return this.b.n() != 0;
    }

    public String h() {
        return this.b.o();
    }

    public void i() {
        this.c = (an) this.d.get(0);
    }

    public an j() {
        return this.c;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("PbData", "parserJson", "error = " + e.getMessage());
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
                        this.d.add(anVar);
                    }
                }
                this.e.a(jSONObject.optJSONObject("page"));
                this.f.a(jSONObject.optJSONObject("anti"));
                this.g.a(jSONObject.optJSONObject(Headers.LOCATION));
                this.h = jSONObject.optInt("has_floor") == 1;
                this.i = jSONObject.optJSONObject("user").optInt("is_manager", 0);
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b("PbData", "parserJson", "error = " + e.getMessage());
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
