package com.baidu.tieba.ala.liveroom.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public String abO;
    public String appUrl;
    public String eWA;
    public String eWB;
    public String eWC;
    public String eWz;
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
                this.eWz = optJSONObject.optString("app_deeplink_url", "");
                this.eWA = optJSONObject.optString("app_backup_deeplink_url", "");
                this.eWB = optJSONObject.optString("app_clipboard_url", "");
            }
            this.abO = jSONObject.optString("toast_text", "");
            this.eWC = jSONObject.optString("subapp_type", "");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.userName = optJSONObject2.optString("user_name", "");
                this.portrait = optJSONObject2.optString("portrait", "");
            }
        }
    }

    public String getSubappType() {
        return this.eWC;
    }

    public String getPortrait() {
        return this.portrait;
    }
}
