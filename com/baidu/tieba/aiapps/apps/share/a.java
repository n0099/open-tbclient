package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class a extends ShareItem {
    public void dh(JSONObject jSONObject) throws JSONException {
        this.eGS = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.eGT = optJSONObject.optString("source2");
            this.eGV = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.eGU = 2;
            this.eGZ = optJSONObject2.optJSONArray("cmd_pannel");
            this.eHa = optJSONObject2.optJSONObject("info");
            if (this.eHa != null) {
                this.eGX = this.eHa.optString("key");
                this.eGY = this.eHa.optString("content");
                return;
            }
            return;
        }
        this.eGU = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bEr() {
        return this.eGZ;
    }

    public String bEs() {
        return this.eGX;
    }

    public String bEt() {
        return this.eGY;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
