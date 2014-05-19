package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private int e = 0;
    private int f = 0;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.e = jSONObject.optInt("user_type");
                this.f = jSONObject.optInt("is_verify");
                this.b = jSONObject.optString("name");
                this.c = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.d = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
            } catch (Exception e) {
                BdLog.e("LikeData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }
}
