package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private c gNd;
    private c gNe;

    public void parse(JSONObject jSONObject) {
        this.gNd = new c();
        this.gNd.dH(jSONObject.optJSONObject("cat1"));
        this.gNe = new c();
        this.gNe.dH(jSONObject.optJSONObject("cat2"));
    }

    public c bTs() {
        return this.gNd;
    }

    public void c(c cVar) {
        this.gNd = cVar;
    }

    public c bTt() {
        return this.gNe;
    }

    public void d(c cVar) {
        this.gNe = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bTs() == null || aVar.bTs().getId() == null) ? "" : aVar.bTs().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bTt() == null || aVar.bTt().getId() == null) ? "" : aVar.bTt().getId();
    }
}
