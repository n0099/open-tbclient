package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private c fSC;
    private c fSD;

    public void parse(JSONObject jSONObject) {
        this.fSC = new c();
        this.fSC.dl(jSONObject.optJSONObject("cat1"));
        this.fSD = new c();
        this.fSD.dl(jSONObject.optJSONObject("cat2"));
    }

    public c bJe() {
        return this.fSC;
    }

    public void c(c cVar) {
        this.fSC = cVar;
    }

    public c bJf() {
        return this.fSD;
    }

    public void d(c cVar) {
        this.fSD = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bJe() == null || aVar.bJe().getId() == null) ? "" : aVar.bJe().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bJf() == null || aVar.bJf().getId() == null) ? "" : aVar.bJf().getId();
    }
}
