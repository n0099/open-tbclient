package com.baidu.tbadk.coreExtra.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int chr;
    private String link;
    private String title;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != null) {
            this.chr = jSONObject.optInt("offline");
            this.title = jSONObject.optString("title");
            this.link = jSONObject.optString(SelectForumActivityConfig.KEY_SHARE_LINK);
            if (!TextUtils.isEmpty(this.link)) {
                this.link = this.link.replaceFirst("webview:", "http://");
            }
        }
    }
}
