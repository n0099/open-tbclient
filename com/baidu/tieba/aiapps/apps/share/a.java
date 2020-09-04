package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a extends ShareItem {
    public void de(JSONObject jSONObject) throws JSONException {
        this.eEM = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.eEN = optJSONObject.optString("source2");
            this.eEP = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.eEO = 2;
            this.eET = optJSONObject2.optJSONArray("cmd_pannel");
            this.eEU = optJSONObject2.optJSONObject("info");
            if (this.eEU != null) {
                this.eER = this.eEU.optString("key");
                this.eES = this.eEU.optString("content");
                return;
            }
            return;
        }
        this.eEO = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bDf() {
        return this.eET;
    }

    public String bDg() {
        return this.eER;
    }

    public String bDh() {
        return this.eES;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
