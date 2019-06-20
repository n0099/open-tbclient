package com.baidu.tbadk.coreExtra.data;

import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private String appId = "";
    private String appName = "";
    private String packageName = "";
    private boolean ceL = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.appId = jSONObject.optString(Constants.APP_ID, "");
            this.appName = jSONObject.optString("app_name", "");
            this.packageName = jSONObject.optString(Constants.PACKAGE_NAME, "");
        }
    }
}
