package com.baidu.tbadk.coreExtra.data;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CombineDownload implements Serializable {
    public static final int SHOW_COMBINE_DOWNLOAD = 1;
    public static final long serialVersionUID = -8311384562580282599L;
    public String apkMD5RSA;
    public String appProc;
    public String appUrl;
    public String appdesc;
    public int isShow;

    public String getApkMD5RSA() {
        return this.apkMD5RSA;
    }

    public String getAppName() {
        return this.appdesc;
    }

    public String getAppProc() {
        return this.appProc;
    }

    public String getAppUrl() {
        return this.appUrl;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.appdesc = jSONObject.optString("app_name");
        this.appUrl = jSONObject.optString("app_url");
        this.appProc = jSONObject.optString("app_proc");
        this.isShow = jSONObject.optInt("is_show");
        this.apkMD5RSA = jSONObject.optString("apk_MD5_RSA");
    }

    public boolean showCombineDownload() {
        return this.isShow == 1;
    }
}
