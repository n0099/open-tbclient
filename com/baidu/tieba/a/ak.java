package com.baidu.tieba.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {
    private p a = new p();
    private as b = new as();
    private ArrayList c = new ArrayList();
    private aj d = new aj();
    private b e = new b();
    private int g = 0;
    private boolean f = false;

    public p a() {
        return this.a;
    }

    public void a(aj ajVar) {
        this.d = ajVar;
    }

    public void a(as asVar) {
        this.b = asVar;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(p pVar) {
        this.a = pVar;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a.a(jSONObject.optJSONObject("forum"));
            this.b.a(jSONObject.optJSONObject("thread"));
            JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    am amVar = new am();
                    amVar.a(optJSONArray.optJSONObject(i));
                    this.c.add(amVar);
                }
            }
            this.d.a(jSONObject.optJSONObject("page"));
            this.e.a(jSONObject.optJSONObject("anti"));
            this.f = jSONObject.optInt("has_floor") == 1;
            this.g = jSONObject.optJSONObject("user").optInt("is_manager", 0);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public as b() {
        return this.b;
    }

    public ArrayList c() {
        return this.c;
    }

    public aj d() {
        return this.d;
    }

    public b e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }
}
