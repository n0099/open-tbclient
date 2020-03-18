package com.baidu.tieba.ala.liveroom.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public String aed;
    public String appUrl;
    public String fba;
    public String fbb;
    public String fbc;
    public String fbd;
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
                this.fba = optJSONObject.optString("app_deeplink_url", "");
                this.fbb = optJSONObject.optString("app_backup_deeplink_url", "");
                this.fbc = optJSONObject.optString("app_clipboard_url", "");
            }
            this.aed = jSONObject.optString("toast_text", "");
            this.fbd = jSONObject.optString("subapp_type", "");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.userName = optJSONObject2.optString("user_name", "");
                this.portrait = optJSONObject2.optString("portrait", "");
            }
        }
    }

    public String getSubappType() {
        return this.fbd;
    }

    public String getPortrait() {
        return this.portrait;
    }
}
