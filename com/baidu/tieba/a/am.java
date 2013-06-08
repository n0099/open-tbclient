package com.baidu.tieba.a;

import android.content.Context;
import com.baidu.zeus.Headers;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class am {
    private ar c;
    private s a = new s();
    private bc b = new bc();
    private ArrayList d = new ArrayList();
    private al e = new al();
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

    public bc b() {
        return this.b;
    }

    public void a(bc bcVar) {
        this.b = bcVar;
    }

    public ad c() {
        return this.g;
    }

    public ArrayList d() {
        return this.d;
    }

    public al e() {
        return this.e;
    }

    public void a(al alVar, int i) {
        this.e.c(alVar.d());
        this.e.b(alVar.b());
        this.e.a(alVar.a());
        this.e.d(alVar.e());
        if (i == 0) {
            this.e = alVar;
        } else if (i == 1) {
            this.e.e(alVar.f());
        } else if (i == 2) {
            this.e.f(alVar.g());
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
        this.c = (ar) this.d.get(0);
    }

    public ar j() {
        return this.c;
    }

    public void a(String str, Context context) {
        try {
            a(new JSONObject(str), context);
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b("PbData", "parserJson", "error = " + e.getMessage());
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
                        ar arVar = new ar();
                        arVar.a(optJSONArray.optJSONObject(i), context);
                        this.d.add(arVar);
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
