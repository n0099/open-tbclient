package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private c fDW;
    private c fDX;

    public void parse(JSONObject jSONObject) {
        this.fDW = new c();
        this.fDW.db(jSONObject.optJSONObject("cat1"));
        this.fDX = new c();
        this.fDX.db(jSONObject.optJSONObject("cat2"));
    }

    public c byS() {
        return this.fDW;
    }

    public void c(c cVar) {
        this.fDW = cVar;
    }

    public c byT() {
        return this.fDX;
    }

    public void d(c cVar) {
        this.fDX = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.byS() == null || aVar.byS().getId() == null) ? "" : aVar.byS().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.byT() == null || aVar.byT().getId() == null) ? "" : aVar.byT().getId();
    }
}
