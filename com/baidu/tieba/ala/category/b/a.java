package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private c geV;
    private c geW;

    public void parse(JSONObject jSONObject) {
        this.geV = new c();
        this.geV.ds(jSONObject.optJSONObject("cat1"));
        this.geW = new c();
        this.geW.ds(jSONObject.optJSONObject("cat2"));
    }

    public c bLO() {
        return this.geV;
    }

    public void c(c cVar) {
        this.geV = cVar;
    }

    public c bLP() {
        return this.geW;
    }

    public void d(c cVar) {
        this.geW = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bLO() == null || aVar.bLO().getId() == null) ? "" : aVar.bLO().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bLP() == null || aVar.bLP().getId() == null) ? "" : aVar.bLP().getId();
    }
}
