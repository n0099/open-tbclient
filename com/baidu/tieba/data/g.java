package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private String f1247a = null;

    public String a() {
        return this.f1247a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1247a = jSONObject.optString(SocialConstants.PARAM_CLIENT_ID);
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
