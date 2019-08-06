package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.coloros.mcssdk.mode.CommandMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.coreExtra.c.e {
    public void bi(JSONObject jSONObject) throws JSONException {
        this.cli = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.clj = optJSONObject.optString("source2");
            this.cll = optJSONObject.optString("source3");
        }
        if (jSONObject.optJSONObject(CommandMessage.COMMAND) != null) {
            this.clk = 2;
        } else {
            this.clk = "url".equals(jSONObject.optString("type")) ? 1 : 3;
        }
    }
}
