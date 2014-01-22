package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    private boolean g = false;
    private int a = 0;
    private String b = null;
    private int e = 0;
    private String c = null;
    private String d = null;
    private String f = null;

    public boolean a() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString("id");
                this.a = jSONObject.optInt("is_login", 0);
                this.e = jSONObject.optInt("no_un", 0);
                this.c = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
                this.d = jSONObject.optString("name_show");
                this.f = jSONObject.optString("portrait");
                if (jSONObject.optInt("is_manager", 0) == 1) {
                    this.g = true;
                } else {
                    this.g = false;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
