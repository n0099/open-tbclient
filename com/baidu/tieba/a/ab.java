package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private int a = 0;
    private String b = null;
    private aa c = new aa();

    public aa a() {
        return this.c;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("LikeReturnData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
                this.a = jSONObject.optInt("error_code", 0);
                this.c.a(jSONObject.optJSONObject("info"));
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b("LikeReturnData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
