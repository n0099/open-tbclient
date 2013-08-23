package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.zeus.Headers;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private v f987a = new v();
    private bh b = new bh();
    private ArrayList c = new ArrayList();
    private an d = new an();
    private AntiData e = new AntiData();
    private ah f = new ah();
    private int h = 0;
    private boolean g = false;

    public boolean a() {
        return this.c != null && this.c.size() > 0;
    }

    public v b() {
        return this.f987a;
    }

    public bh c() {
        return this.b;
    }

    public ArrayList d() {
        return this.c;
    }

    public an e() {
        return this.d;
    }

    public void a(an anVar, int i) {
        this.d.c(anVar.d());
        this.d.b(anVar.b());
        this.d.a(anVar.a());
        this.d.d(anVar.e());
        if (i == 0) {
            this.d = anVar;
        } else if (i == 1) {
            this.d.e(anVar.f());
        } else if (i == 2) {
            this.d.f(anVar.g());
        }
    }

    public AntiData f() {
        return this.e;
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

    public void a(String str, Context context) {
        try {
            a(new JSONObject(str), context);
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, (Context) null);
    }

    public void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                this.f987a.a(jSONObject.optJSONObject("forum"));
                this.b.a(jSONObject.optJSONObject("thread"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        as asVar = new as();
                        asVar.a(optJSONArray.optJSONObject(i), context);
                        this.c.add(asVar);
                    }
                }
                this.d.a(jSONObject.optJSONObject("page"));
                this.e.parserJson(jSONObject.optJSONObject("anti"));
                this.f.a(jSONObject.optJSONObject(Headers.LOCATION));
                this.g = jSONObject.optInt("has_floor") == 1;
                this.h = jSONObject.optJSONObject("user").optInt("is_manager", 0);
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b("PbData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public boolean i() {
        return this.g;
    }

    public int j() {
        return this.h;
    }
}
