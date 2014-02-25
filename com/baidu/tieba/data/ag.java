package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {
    private String a = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
