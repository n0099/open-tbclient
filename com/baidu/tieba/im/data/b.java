package com.baidu.tieba.im.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public String a;
    public int b;
    public int c;
    public String d;
    public String e;
    public int f;
    public int g;
    public int h;
    public String i;
    public String j;

    private b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optString("userMsg");
            this.h = com.baidu.adp.lib.f.b.a(jSONObject.optString("eventId"), 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
            if (optJSONObject != null) {
                this.b = com.baidu.adp.lib.f.b.a(optJSONObject.optString("groupId"), 0);
                this.c = com.baidu.adp.lib.f.b.a(optJSONObject.optString("userId"), 0);
                this.f = com.baidu.adp.lib.f.b.a(optJSONObject.optString("userNum"), 0);
                this.g = com.baidu.adp.lib.f.b.a(optJSONObject.optString("maxUserNum"), 0);
                this.j = optJSONObject.optString("title");
                this.i = optJSONObject.optString("content");
                this.d = optJSONObject.optString("userName");
                this.e = optJSONObject.optString("portrait");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static b a(String str) {
        return new b(str);
    }
}
