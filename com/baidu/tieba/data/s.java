package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.bo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private String a = null;
    private String b = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private String h = null;
    private String i = null;

    public String a() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("id");
                this.b = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
                this.c = jSONObject.optInt("member_count", 0);
                this.d = jSONObject.optInt("is_like", 0);
                this.e = this.d;
                this.f = jSONObject.optInt("level_id", 1);
                this.g = jSONObject.optInt("favo_type", 0);
                this.h = jSONObject.optString("desc");
                this.i = jSONObject.optString("avatar", "");
            } catch (Exception e) {
                bo.b("LikeForumData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
