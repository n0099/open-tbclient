package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private c fPn;
    private c fPo;

    public void parse(JSONObject jSONObject) {
        this.fPn = new c();
        this.fPn.di(jSONObject.optJSONObject("cat1"));
        this.fPo = new c();
        this.fPo.di(jSONObject.optJSONObject("cat2"));
    }

    public c bHV() {
        return this.fPn;
    }

    public void c(c cVar) {
        this.fPn = cVar;
    }

    public c bHW() {
        return this.fPo;
    }

    public void d(c cVar) {
        this.fPo = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bHV() == null || aVar.bHV().getId() == null) ? "" : aVar.bHV().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bHW() == null || aVar.bHW().getId() == null) ? "" : aVar.bHW().getId();
    }
}
