package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private String a = null;
    private String b = null;
    private String c = null;
    private String d = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("player_id");
                this.b = jSONObject.optString("player_name");
                this.c = jSONObject.optString("small_head_url");
                a(jSONObject.optString("big_head_url"));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("PlayerInfoData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(String str) {
        this.d = str;
    }
}
