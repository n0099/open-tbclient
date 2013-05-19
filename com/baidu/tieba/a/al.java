package com.baidu.tieba.a;

import com.baidu.zeus.Headers;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    private aq c;
    private s a = new s();
    private bb b = new bb();
    private ArrayList d = new ArrayList();
    private ak e = new ak();
    private b f = new b();
    private ad g = new ad();
    private int i = 0;
    private boolean h = false;

    public s a() {
        return this.a;
    }

    public void a(s sVar) {
        this.a = sVar;
    }

    public bb b() {
        return this.b;
    }

    public void a(bb bbVar) {
        this.b = bbVar;
    }

    public ad c() {
        return this.g;
    }

    public ArrayList d() {
        return this.d;
    }

    public ak e() {
        return this.e;
    }

    public void a(ak akVar, int i) {
        this.e.c(akVar.c());
        this.e.b(akVar.b());
        this.e.a(akVar.a());
        this.e.d(akVar.d());
        if (i == 0) {
            this.e = akVar;
        } else if (i == 1) {
            this.e.e(akVar.e());
        } else if (i == 2) {
            this.e.f(akVar.f());
        }
    }

    public void a(b bVar) {
        this.f = bVar;
    }

    public b f() {
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
        this.c = (aq) this.d.get(0);
    }

    public aq j() {
        return this.c;
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PbData", "parserJson", "error = " + e.getMessage());
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
                        aq aqVar = new aq();
                        aqVar.a(optJSONArray.optJSONObject(i));
                        this.d.add(aqVar);
                    }
                }
                this.e.a(jSONObject.optJSONObject("page"));
                this.f.a(jSONObject.optJSONObject("anti"));
                this.g.a(jSONObject.optJSONObject(Headers.LOCATION));
                this.h = jSONObject.optInt("has_floor") == 1;
                this.i = jSONObject.optJSONObject("user").optInt("is_manager", 0);
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b("PbData", "parserJson", "error = " + e.getMessage());
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
