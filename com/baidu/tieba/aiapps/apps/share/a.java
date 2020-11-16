package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class a extends ShareItem {
    public void dr(JSONObject jSONObject) throws JSONException {
        this.fgu = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.fgv = optJSONObject.optString("source2");
            this.fgx = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.fgw = 2;
            this.fgB = optJSONObject2.optJSONArray("cmd_pannel");
            this.fgC = optJSONObject2.optJSONObject("info");
            if (this.fgC != null) {
                this.fgz = this.fgC.optString("key");
                this.fgA = this.fgC.optString("content");
                return;
            }
            return;
        }
        this.fgw = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bKO() {
        return this.fgB;
    }

    public String bKP() {
        return this.fgz;
    }

    public String bKQ() {
        return this.fgA;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
