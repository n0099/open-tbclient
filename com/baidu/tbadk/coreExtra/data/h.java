package com.baidu.tbadk.coreExtra.data;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.webkit.internal.ETAG;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private String appId = "";
    private String appName = "";
    private String packageName = "";
    private boolean aOl = false;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.appId = jSONObject.optString(HttpConstants.HTTP_APP_ID, "");
            this.appName = jSONObject.optString(AiAppsApsUtils.APP_NAME, "");
            this.packageName = jSONObject.optString(ETAG.KEY_PACKAGE_NAME, "");
        }
    }
}
