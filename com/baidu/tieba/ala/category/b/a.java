package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private c fnq;
    private c fnr;

    public void parse(JSONObject jSONObject) {
        this.fnq = new c();
        this.fnq.cM(jSONObject.optJSONObject("cat1"));
        this.fnr = new c();
        this.fnr.cM(jSONObject.optJSONObject("cat2"));
    }

    public c bsL() {
        return this.fnq;
    }

    public void c(c cVar) {
        this.fnq = cVar;
    }

    public c bsM() {
        return this.fnr;
    }

    public void d(c cVar) {
        this.fnr = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bsL() == null || aVar.bsL().getId() == null) ? "" : aVar.bsL().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bsM() == null || aVar.bsM().getId() == null) ? "" : aVar.bsM().getId();
    }
}
