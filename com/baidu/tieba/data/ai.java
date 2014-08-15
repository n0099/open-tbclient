package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai extends an {
    private int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    @Override // com.baidu.tieba.data.an
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("pos", 1);
                this.b = jSONObject.optString("app_name", "");
                this.c = jSONObject.optString("app_desc", "");
                this.d = jSONObject.optString("p_name", "");
                this.e = jSONObject.optString("p_url", "");
                this.f = jSONObject.optString("web_url", "");
                this.g = jSONObject.optString("img_url", "");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
