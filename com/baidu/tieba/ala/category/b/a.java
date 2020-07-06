package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private c fyP;
    private c fyQ;

    public void parse(JSONObject jSONObject) {
        this.fyP = new c();
        this.fyP.cV(jSONObject.optJSONObject("cat1"));
        this.fyQ = new c();
        this.fyQ.cV(jSONObject.optJSONObject("cat2"));
    }

    public c bvJ() {
        return this.fyP;
    }

    public void c(c cVar) {
        this.fyP = cVar;
    }

    public c bvK() {
        return this.fyQ;
    }

    public void d(c cVar) {
        this.fyQ = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bvJ() == null || aVar.bvJ().getId() == null) ? "" : aVar.bvJ().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bvK() == null || aVar.bvK().getId() == null) ? "" : aVar.bvK().getId();
    }
}
