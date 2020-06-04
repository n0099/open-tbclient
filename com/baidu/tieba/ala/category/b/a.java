package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private c fnB;
    private c fnC;

    public void parse(JSONObject jSONObject) {
        this.fnB = new c();
        this.fnB.cM(jSONObject.optJSONObject("cat1"));
        this.fnC = new c();
        this.fnC.cM(jSONObject.optJSONObject("cat2"));
    }

    public c bsN() {
        return this.fnB;
    }

    public void c(c cVar) {
        this.fnB = cVar;
    }

    public c bsO() {
        return this.fnC;
    }

    public void d(c cVar) {
        this.fnC = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bsN() == null || aVar.bsN().getId() == null) ? "" : aVar.bsN().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bsO() == null || aVar.bsO().getId() == null) ? "" : aVar.bsO().getId();
    }
}
