package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private String f1163a = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1163a = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
            } catch (Exception e) {
                bg.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
