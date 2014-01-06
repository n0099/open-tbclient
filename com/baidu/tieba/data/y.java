package com.baidu.tieba.data;

import com.baidu.tieba.util.bo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {
    private int a;
    private String b;
    private String c;

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("bannerType");
                this.b = jSONObject.optString("bannerUrl");
                this.c = jSONObject.optString("value");
            } catch (Exception e) {
                bo.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
