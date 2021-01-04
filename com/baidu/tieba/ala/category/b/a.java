package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private c gOP;
    private c gOQ;

    public void parse(JSONObject jSONObject) {
        this.gOP = new c();
        this.gOP.dG(jSONObject.optJSONObject("cat1"));
        this.gOQ = new c();
        this.gOQ.dG(jSONObject.optJSONObject("cat2"));
    }

    public c bWz() {
        return this.gOP;
    }

    public void c(c cVar) {
        this.gOP = cVar;
    }

    public c bWA() {
        return this.gOQ;
    }

    public void d(c cVar) {
        this.gOQ = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bWz() == null || aVar.bWz().getId() == null) ? "" : aVar.bWz().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bWA() == null || aVar.bWA().getId() == null) ? "" : aVar.bWA().getId();
    }
}
