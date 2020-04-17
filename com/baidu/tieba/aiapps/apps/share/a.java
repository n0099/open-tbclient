package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a extends ShareItem {
    public void cE(JSONObject jSONObject) throws JSONException {
        this.dQN = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.dQO = optJSONObject.optString("source2");
            this.dQQ = optJSONObject.optString("source3");
        }
        if (jSONObject.optJSONObject("command") != null) {
            this.dQP = 2;
        } else {
            this.dQP = "url".equals(jSONObject.optString("type")) ? 1 : 3;
        }
    }
}
