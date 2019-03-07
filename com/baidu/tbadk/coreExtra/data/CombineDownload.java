package com.baidu.tbadk.coreExtra.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CombineDownload implements Serializable {
    private static final long serialVersionUID = -8311384562580282599L;
    private String apkMD5RSA;
    private String appProc;
    private String appUrl;
    private String appdesc;
    private int isShow;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.appdesc = jSONObject.optString("app_name");
            this.appUrl = jSONObject.optString("app_url");
            this.appProc = jSONObject.optString("app_proc");
            this.isShow = jSONObject.optInt("is_show");
            this.apkMD5RSA = jSONObject.optString("apk_MD5_RSA");
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

    public boolean showCombineDownload() {
        return this.isShow == 1;
    }

    public String getApkMD5RSA() {
        return this.apkMD5RSA;
    }
}
