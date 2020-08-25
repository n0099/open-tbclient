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
        this.eEI = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.eEJ = optJSONObject.optString("source2");
            this.eEL = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.eEK = 2;
            this.eEP = optJSONObject2.optJSONArray("cmd_pannel");
            this.eEQ = optJSONObject2.optJSONObject("info");
            if (this.eEQ != null) {
                this.eEN = this.eEQ.optString("key");
                this.eEO = this.eEQ.optString("content");
                return;
            }
            return;
        }
        this.eEK = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bDe() {
        return this.eEP;
    }

    public String bDf() {
        return this.eEN;
    }

    public String bDg() {
        return this.eEO;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
