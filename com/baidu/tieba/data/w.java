package com.baidu.tieba.data;

import com.baidu.tieba.person.PersonInfoActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class w {
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private int e = 0;
    private int f = 0;

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.e = jSONObject.optInt("user_type");
                this.f = jSONObject.optInt("is_verify");
                this.b = jSONObject.optString(PersonInfoActivity.TAG_NAME);
                this.c = jSONObject.optString("name_show");
                this.d = jSONObject.optString("portrait");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("LikeData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }
}
