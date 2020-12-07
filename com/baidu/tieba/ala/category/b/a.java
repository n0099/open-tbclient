package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private c gDb;
    private c gDc;

    public void parse(JSONObject jSONObject) {
        this.gDb = new c();
        this.gDb.dx(jSONObject.optJSONObject("cat1"));
        this.gDc = new c();
        this.gDc.dx(jSONObject.optJSONObject("cat2"));
    }

    public c bTT() {
        return this.gDb;
    }

    public void c(c cVar) {
        this.gDb = cVar;
    }

    public c bTU() {
        return this.gDc;
    }

    public void d(c cVar) {
        this.gDc = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bTT() == null || aVar.bTT().getId() == null) ? "" : aVar.bTT().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bTU() == null || aVar.bTU().getId() == null) ? "" : aVar.bTU().getId();
    }
}
