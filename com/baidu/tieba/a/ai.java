package com.baidu.tieba.a;

import com.baidu.zeus.Headers;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {
    private al c;
    private q a = new q();
    private at b = new at();
    private ArrayList d = new ArrayList();
    private ah e = new ah();
    private b f = new b();
    private aa g = new aa();
    private int i = 0;
    private boolean h = false;

    public q a() {
        return this.a;
    }

    public void a(q qVar) {
        this.a = qVar;
    }

    public at b() {
        return this.b;
    }

    public void a(at atVar) {
        this.b = atVar;
    }

    public aa c() {
        return this.g;
    }

    public ArrayList d() {
        return this.d;
    }

    public ah e() {
        return this.e;
    }

    public void a(ah ahVar) {
        this.e = ahVar;
    }

    public void a(b bVar) {
        this.f = bVar;
    }

    public b f() {
        return this.f;
    }

    public void g() {
        this.c = (al) this.d.get(0);
    }

    public al h() {
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
                        al alVar = new al();
                        alVar.a(optJSONArray.optJSONObject(i));
                        this.d.add(alVar);
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

    public boolean i() {
        return this.h;
    }

    public int j() {
        return this.i;
    }
}
