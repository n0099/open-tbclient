package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    public static String f1155a = "meizhi_level";
    private String b = null;
    private String c = null;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString("icon");
                this.c = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
            } catch (Exception e) {
                bg.b(getClass().getName(), "parserJson", "error=" + e.toString());
            }
        }
    }
}
