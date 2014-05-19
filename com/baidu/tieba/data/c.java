package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private String a;

    public String a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("client_id");
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
