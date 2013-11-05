package com.baidu.tieba.data;

import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private int f1176a = -1;
    private String b = null;
    private String c = null;

    public int a() {
        return this.f1176a;
    }

    public void a(int i) {
        this.f1176a = i;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1176a = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE, 0);
                this.b = jSONObject.optString("error_msg");
                this.c = jSONObject.optString("error_data");
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
