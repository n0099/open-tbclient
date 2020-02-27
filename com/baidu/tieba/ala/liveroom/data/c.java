package com.baidu.tieba.ala.liveroom.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public String adT;
    public String appUrl;
    public String fao;
    public String fap;
    public String faq;
    public String far;
    public int needToast;
    public String packageName;
    public String portrait;
    public String userName;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.needToast = jSONObject.optInt("need_toast", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("jump_conf");
            if (optJSONObject != null) {
                this.packageName = optJSONObject.optString("package_name", "");
                this.appUrl = optJSONObject.optString("app_url", "");
                this.fao = optJSONObject.optString("app_deeplink_url", "");
                this.fap = optJSONObject.optString("app_backup_deeplink_url", "");
                this.faq = optJSONObject.optString("app_clipboard_url", "");
            }
            this.adT = jSONObject.optString("toast_text", "");
            this.far = jSONObject.optString("subapp_type", "");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.userName = optJSONObject2.optString("user_name", "");
                this.portrait = optJSONObject2.optString("portrait", "");
            }
        }
    }

    public String getSubappType() {
        return this.far;
    }

    public String getPortrait() {
        return this.portrait;
    }
}
