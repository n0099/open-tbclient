package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private int bfM;
    private String link;
    private String title;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.bfM = jSONObject.optInt("offline");
            this.title = jSONObject.optString("title");
            this.link = jSONObject.optString("link");
            if (!TextUtils.isEmpty(this.link)) {
                this.link = this.link.replaceFirst("webview:", "http://");
            }
        }
    }
}
