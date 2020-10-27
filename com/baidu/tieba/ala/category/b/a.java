package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private c goY;
    private c goZ;

    public void parse(JSONObject jSONObject) {
        this.goY = new c();
        this.goY.dw(jSONObject.optJSONObject("cat1"));
        this.goZ = new c();
        this.goZ.dw(jSONObject.optJSONObject("cat2"));
    }

    public c bOq() {
        return this.goY;
    }

    public void c(c cVar) {
        this.goY = cVar;
    }

    public c bOr() {
        return this.goZ;
    }

    public void d(c cVar) {
        this.goZ = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bOq() == null || aVar.bOq().getId() == null) ? "" : aVar.bOq().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bOr() == null || aVar.bOr().getId() == null) ? "" : aVar.bOr().getId();
    }
}
