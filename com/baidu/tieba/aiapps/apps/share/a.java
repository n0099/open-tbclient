package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends ShareItem {
    public void dB(JSONObject jSONObject) throws JSONException {
        this.fsV = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.fsW = optJSONObject.optString("source2");
            this.fsY = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.fsX = 2;
            this.ftc = optJSONObject2.optJSONArray("cmd_pannel");
            this.ftd = optJSONObject2.optJSONObject("info");
            if (this.ftd != null) {
                this.fta = this.ftd.optString("key");
                this.ftb = this.ftd.optString("content");
                return;
            }
            return;
        }
        this.fsX = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bMY() {
        return this.ftc;
    }

    public String bMZ() {
        return this.fta;
    }

    public String bNa() {
        return this.ftb;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
