package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String appId = "";
    private String ars = "";
    private String packageName = "";
    private boolean art = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.appId = jSONObject.optString("app_id", "");
            this.ars = jSONObject.optString("app_name", "");
            this.packageName = jSONObject.optString("package_name", "");
        }
    }

    public String getAppId() {
        return this.appId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public boolean yh() {
        return this.art;
    }

    public void aT(boolean z) {
        this.art = z;
    }
}
