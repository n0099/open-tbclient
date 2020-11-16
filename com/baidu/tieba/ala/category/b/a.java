package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private c gus;
    private c gut;

    public void parse(JSONObject jSONObject) {
        this.gus = new c();
        this.gus.dw(jSONObject.optJSONObject("cat1"));
        this.gut = new c();
        this.gut.dw(jSONObject.optJSONObject("cat2"));
    }

    public c bQj() {
        return this.gus;
    }

    public void c(c cVar) {
        this.gus = cVar;
    }

    public c bQk() {
        return this.gut;
    }

    public void d(c cVar) {
        this.gut = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bQj() == null || aVar.bQj().getId() == null) ? "" : aVar.bQj().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bQk() == null || aVar.bQk().getId() == null) ? "" : aVar.bQk().getId();
    }
}
