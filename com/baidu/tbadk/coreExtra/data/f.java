package com.baidu.tbadk.coreExtra.data;

import com.baidu.ar.constants.HttpConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private String appId = "";
    private String appName = "";
    private String packageName = "";
    private boolean aBM = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.appId = jSONObject.optString(HttpConstants.HTTP_APP_ID, "");
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

    public boolean BZ() {
        return this.aBM;
    }

    public void ba(boolean z) {
        this.aBM = z;
    }
}
