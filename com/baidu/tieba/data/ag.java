package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class ag {
    private String a = null;

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
