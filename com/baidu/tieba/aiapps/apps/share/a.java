package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends ShareItem {
    public void dr(JSONObject jSONObject) throws JSONException {
        this.fbv = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.fbw = optJSONObject.optString("source2");
            this.fby = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.fbx = 2;
            this.fbC = optJSONObject2.optJSONArray("cmd_pannel");
            this.fbD = optJSONObject2.optJSONObject("info");
            if (this.fbD != null) {
                this.fbA = this.fbD.optString("key");
                this.fbB = this.fbD.optString("content");
                return;
            }
            return;
        }
        this.fbx = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bIW() {
        return this.fbC;
    }

    public String bIX() {
        return this.fbA;
    }

    public String bIY() {
        return this.fbB;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
