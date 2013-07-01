package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    private String f781a = null;
    private String b = null;
    private String c = null;

    public String a() {
        return this.f781a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject == null) {
                optJSONObject = jSONObject.optJSONObject("anti");
            }
            a(optJSONObject);
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("VcodeInfoData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f781a = jSONObject.optString("vcode_md5");
                this.b = jSONObject.optString("vcode_pic_url");
                this.c = jSONObject.optString("vcode_type");
            } catch (Exception e) {
                com.baidu.tieba.util.z.b("VcodeInfoData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
