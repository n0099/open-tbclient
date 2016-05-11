package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private int afZ;
    private String link;
    private String title;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.afZ = jSONObject.optInt("offline");
            this.title = jSONObject.optString("title");
            this.link = jSONObject.optString("link");
            if (!TextUtils.isEmpty(this.link)) {
                this.link = this.link.replaceFirst("webview:", "http://");
            }
        }
    }
}
