package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private int QJ;
    private String link;
    private String title;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.QJ = jSONObject.optInt("offline");
            this.title = jSONObject.optString("title");
            this.link = jSONObject.optString("link");
            if (!TextUtils.isEmpty(this.link)) {
                this.link = this.link.replaceFirst("webview:", "http://");
            }
        }
    }
}
