package com.baidu.tieba.ala.category.b;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private c gOM;
    private c gON;

    public void parse(JSONObject jSONObject) {
        this.gOM = new c();
        this.gOM.dJ(jSONObject.optJSONObject("cat1"));
        this.gON = new c();
        this.gON.dJ(jSONObject.optJSONObject("cat2"));
    }

    public c bTy() {
        return this.gOM;
    }

    public void c(c cVar) {
        this.gOM = cVar;
    }

    public c bTz() {
        return this.gON;
    }

    public void d(c cVar) {
        this.gON = cVar;
    }

    public static String a(a aVar) {
        return (aVar == null || aVar.bTy() == null || aVar.bTy().getId() == null) ? "" : aVar.bTy().getId();
    }

    public static String b(a aVar) {
        return (aVar == null || aVar.bTz() == null || aVar.bTz().getId() == null) ? "" : aVar.bTz().getId();
    }
}
