package com.baidu.tieba.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CombineDownload implements Serializable {
    private static final long serialVersionUID = -8311384562580282599L;
    private String appProc;
    private String appUrl;
    private String appdesc;
    private int isShow;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.appdesc = jSONObject.optString("app_name");
            this.appUrl = jSONObject.optString("app_url");
            this.appProc = jSONObject.optString("app_proc");
            this.isShow = jSONObject.optInt("is_show");
        }
    }

    public String getAppName() {
        return this.appdesc;
    }

    public String getAppUrl() {
        return this.appUrl;
    }

    public String getAppProc() {
        return this.appProc;
    }

    public int getIsShow() {
        return this.isShow;
    }
}
