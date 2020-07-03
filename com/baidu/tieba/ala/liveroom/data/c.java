package com.baidu.tieba.ala.liveroom.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public String appUrl;
    public String ayj;
    public String gfZ;
    public String gga;
    public String ggb;
    public String ggc;
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
                this.gfZ = optJSONObject.optString("app_deeplink_url", "");
                this.gga = optJSONObject.optString("app_backup_deeplink_url", "");
                this.ggb = optJSONObject.optString("app_clipboard_url", "");
            }
            this.ayj = jSONObject.optString("toast_text", "");
            this.ggc = jSONObject.optString("subapp_type", "");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.userName = optJSONObject2.optString("user_name", "");
                this.portrait = optJSONObject2.optString("portrait", "");
            }
        }
    }

    public String getSubappType() {
        return this.ggc;
    }

    public String getPortrait() {
        return this.portrait;
    }
}
