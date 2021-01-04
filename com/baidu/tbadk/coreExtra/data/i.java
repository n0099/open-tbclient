package com.baidu.tbadk.coreExtra.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private String appId = "";
    private String appName = "";
    private String packageName = "";
    private boolean fsT = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.appId = jSONObject.optString("app_id", "");
            this.appName = jSONObject.optString("app_name", "");
            this.packageName = jSONObject.optString("package_name", "");
        }
    }
}
