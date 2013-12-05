package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private int f1218a = 0;
    private String b = null;
    private int e = 0;
    private String c = null;
    private String d = null;
    private String f = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString(LocaleUtil.INDONESIAN);
                this.f1218a = jSONObject.optInt("is_login", 0);
                this.e = jSONObject.optInt("no_un", 0);
                this.c = jSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
                this.d = jSONObject.optString("name_show");
                this.f = jSONObject.optString("portrait");
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
