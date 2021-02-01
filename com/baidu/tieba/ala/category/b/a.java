package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private c gMP;
    private c gMQ;

    public void parse(JSONObject jSONObject) {
        this.gMP = new c();
        this.gMP.dH(jSONObject.optJSONObject("cat1"));
        this.gMQ = new c();
        this.gMQ.dH(jSONObject.optJSONObject("cat2"));
    }

    public c bTl() {
        return this.gMP;
    }

    public void c(c cVar) {
        this.gMP = cVar;
    }

    public c bTm() {
        return this.gMQ;
    }

    public void d(c cVar) {
        this.gMQ = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bTl() == null || aVar.bTl().getId() == null) ? "" : aVar.bTl().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bTm() == null || aVar.bTm().getId() == null) ? "" : aVar.bTm().getId();
    }
}
