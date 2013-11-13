package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private String f1195a = null;

    public String a() {
        return this.f1195a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1195a = jSONObject.optString(SocialConstants.PARAM_CLIENT_ID);
            } catch (Exception e) {
                bg.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
