package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private c fPr;
    private c fPs;

    public void parse(JSONObject jSONObject) {
        this.fPr = new c();
        this.fPr.di(jSONObject.optJSONObject("cat1"));
        this.fPs = new c();
        this.fPs.di(jSONObject.optJSONObject("cat2"));
    }

    public c bHW() {
        return this.fPr;
    }

    public void c(c cVar) {
        this.fPr = cVar;
    }

    public c bHX() {
        return this.fPs;
    }

    public void d(c cVar) {
        this.fPs = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bHW() == null || aVar.bHW().getId() == null) ? "" : aVar.bHW().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bHX() == null || aVar.bHX().getId() == null) ? "" : aVar.bHX().getId();
    }
}
