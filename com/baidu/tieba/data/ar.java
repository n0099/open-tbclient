package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ar {

    /* renamed from: a  reason: collision with root package name */
    private String f1138a = null;
    private String b = null;
    private String c = null;
    private String d = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1138a = jSONObject.optString("player_id");
                this.b = jSONObject.optString("player_name");
                this.c = jSONObject.optString("small_head_url");
                a(jSONObject.optString("big_head_url"));
            } catch (Exception e) {
                com.baidu.tieba.util.be.b("PlayerInfoData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }
}
