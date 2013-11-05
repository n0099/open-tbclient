package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    private String f1128a = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1128a = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
