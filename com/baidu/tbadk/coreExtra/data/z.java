package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class z {
    private String link;
    private int offline;
    private String title;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.offline = jSONObject.optInt("offline");
            this.title = jSONObject.optString("title");
            this.link = jSONObject.optString("link");
            if (!TextUtils.isEmpty(this.link)) {
                this.link = this.link.replaceFirst("webview:", "http://");
            }
        }
    }
}
