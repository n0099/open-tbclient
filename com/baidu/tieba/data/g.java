package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String a = null;

    public String a() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString(SocialConstants.PARAM_CLIENT_ID);
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
