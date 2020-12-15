package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends ShareItem {
    public void ds(JSONObject jSONObject) throws JSONException {
        this.fnU = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.fnV = optJSONObject.optString("source2");
            this.fnX = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.fnW = 2;
            this.fob = optJSONObject2.optJSONArray("cmd_pannel");
            this.foc = optJSONObject2.optJSONObject("info");
            if (this.foc != null) {
                this.fnZ = this.foc.optString("key");
                this.foa = this.foc.optString("content");
                return;
            }
            return;
        }
        this.fnW = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bOx() {
        return this.fob;
    }

    public String bOy() {
        return this.fnZ;
    }

    public String bOz() {
        return this.foa;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
