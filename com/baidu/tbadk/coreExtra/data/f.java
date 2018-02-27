package com.baidu.tbadk.coreExtra.data;

import com.baidu.ar.util.Constants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private String appId = "";
    private String appName = "";
    private String packageName = "";
    private boolean bhh = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.appId = jSONObject.optString(Constants.HTTP_APP_ID, "");
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

    public boolean FD() {
        return this.bhh;
    }

    public void bD(boolean z) {
        this.bhh = z;
    }
}
