package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.zeus.Headers;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {

    /* renamed from: a  reason: collision with root package name */
    private v f983a = new v();
    private bm b = new bm();
    private ArrayList c = new ArrayList();
    private ar d = new ar();
    private AntiData e = new AntiData();
    private al f = new al();
    private int h = 0;
    private boolean g = false;

    public v a() {
        return this.f983a;
    }

    public bm b() {
        return this.b;
    }

    public ArrayList c() {
        return this.c;
    }

    public ar d() {
        return this.d;
    }

    public void a(ar arVar, int i) {
        this.d.c(arVar.d());
        this.d.b(arVar.b());
        this.d.a(arVar.a());
        this.d.d(arVar.e());
        if (i == 0) {
            this.d = arVar;
        } else if (i == 1) {
            this.d.e(arVar.f());
        } else if (i == 2) {
            this.d.f(arVar.g());
        }
    }

    public AntiData e() {
        return this.e;
    }

    public boolean f() {
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

    public String g() {
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
            com.baidu.tieba.util.aj.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("PbData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject, (Context) null);
    }

    public void a(JSONObject jSONObject, Context context) {
        if (jSONObject != null) {
            try {
                this.f983a.a(jSONObject.optJSONObject("forum"));
                this.b.a(jSONObject.optJSONObject("thread"));
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        aw awVar = new aw();
                        awVar.a(optJSONArray.optJSONObject(i), context);
                        this.c.add(awVar);
                    }
                }
                this.d.a(jSONObject.optJSONObject("page"));
                this.e.parserJson(jSONObject.optJSONObject("anti"));
                this.f.a(jSONObject.optJSONObject(Headers.LOCATION));
                this.g = jSONObject.optInt("has_floor") == 1;
                this.h = jSONObject.optJSONObject("user").optInt("is_manager", 0);
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("PbData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public boolean h() {
        return this.g;
    }

    public int i() {
        return this.h;
    }
}
