package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private c gKj;
    private c gKk;

    public void parse(JSONObject jSONObject) {
        this.gKj = new c();
        this.gKj.dG(jSONObject.optJSONObject("cat1"));
        this.gKk = new c();
        this.gKk.dG(jSONObject.optJSONObject("cat2"));
    }

    public c bSI() {
        return this.gKj;
    }

    public void c(c cVar) {
        this.gKj = cVar;
    }

    public c bSJ() {
        return this.gKk;
    }

    public void d(c cVar) {
        this.gKk = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bSI() == null || aVar.bSI().getId() == null) ? "" : aVar.bSI().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bSJ() == null || aVar.bSJ().getId() == null) ? "" : aVar.bSJ().getId();
    }
}
