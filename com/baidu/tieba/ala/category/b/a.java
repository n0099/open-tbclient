package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private c guL;
    private c guM;

    public void parse(JSONObject jSONObject) {
        this.guL = new c();
        this.guL.dC(jSONObject.optJSONObject("cat1"));
        this.guM = new c();
        this.guM.dC(jSONObject.optJSONObject("cat2"));
    }

    public c bQQ() {
        return this.guL;
    }

    public void c(c cVar) {
        this.guL = cVar;
    }

    public c bQR() {
        return this.guM;
    }

    public void d(c cVar) {
        this.guM = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bQQ() == null || aVar.bQQ().getId() == null) ? "" : aVar.bQQ().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bQR() == null || aVar.bQR().getId() == null) ? "" : aVar.bQR().getId();
    }
}
