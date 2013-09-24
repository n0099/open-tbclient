package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private aw f1012a = null;
    private aw b = null;
    private aw c = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1012a = a(jSONObject, "banner_big");
            this.b = a(jSONObject, "banner_small_left");
            this.c = a(jSONObject, "banner_small_right");
        }
    }

    private aw a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        aw awVar = new aw(this);
        awVar.a(optJSONObject.optString("img_url"));
        awVar.b(optJSONObject.optString("link"));
        return awVar;
    }

    public aw a() {
        return this.f1012a;
    }

    public aw b() {
        return this.b;
    }

    public aw c() {
        return this.c;
    }
}
