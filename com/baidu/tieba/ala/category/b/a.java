package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private c gDd;
    private c gDe;

    public void parse(JSONObject jSONObject) {
        this.gDd = new c();
        this.gDd.dx(jSONObject.optJSONObject("cat1"));
        this.gDe = new c();
        this.gDe.dx(jSONObject.optJSONObject("cat2"));
    }

    public c bTU() {
        return this.gDd;
    }

    public void c(c cVar) {
        this.gDd = cVar;
    }

    public c bTV() {
        return this.gDe;
    }

    public void d(c cVar) {
        this.gDe = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bTU() == null || aVar.bTU().getId() == null) ? "" : aVar.bTU().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bTV() == null || aVar.bTV().getId() == null) ? "" : aVar.bTV().getId();
    }
}
