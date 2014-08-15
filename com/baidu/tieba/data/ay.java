package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ay {
    private String a = null;
    private String d = null;
    private String b = null;
    private int c = 0;
    private az e = new az();

    public String a() {
        return this.d;
    }

    public az b() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.c;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("tid");
                this.b = jSONObject.optString("title");
                this.c = jSONObject.optInt("reply_amount", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("user");
                if (optJSONObject != null) {
                    this.d = optJSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                }
                this.e.a(jSONObject.optJSONObject("photo"));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
