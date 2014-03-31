package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f {
    private String a = null;
    private String b = null;
    private String c = null;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject == null) {
                optJSONObject = jSONObject.optJSONObject("anti");
            }
            if (optJSONObject != null) {
                try {
                    this.a = optJSONObject.optString("vcode_md5");
                    this.b = optJSONObject.optString("vcode_pic_url");
                    this.c = optJSONObject.optString("vcode_type");
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("VcodeInfoData", "parserJson", "error = " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b("VcodeInfoData", "parserJson", "error = " + e2.getMessage());
        }
    }
}
