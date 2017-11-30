package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String appId = "";
    private String appName = "";
    private String packageName = "";
    private boolean are = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.appId = jSONObject.optString("app_id", "");
            this.appName = jSONObject.optString("app_name", "");
            this.packageName = jSONObject.optString("package_name", "");
        }
    }

    public String getAppId() {
        return this.appId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public boolean xP() {
        return this.are;
    }

    public void aQ(boolean z) {
        this.are = z;
    }
}
