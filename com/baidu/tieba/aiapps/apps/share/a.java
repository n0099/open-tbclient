package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a extends ShareItem {
    public void cX(JSONObject jSONObject) throws JSONException {
        this.eui = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.euj = optJSONObject.optString("source2");
            this.eul = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.euk = 2;
            this.eup = optJSONObject2.optJSONArray("cmd_pannel");
            this.euq = optJSONObject2.optJSONObject("info");
            if (this.euq != null) {
                this.eun = this.euq.optString("key");
                this.euo = this.euq.optString("content");
                return;
            }
            return;
        }
        this.euk = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray buj() {
        return this.eup;
    }

    public String buk() {
        return this.eun;
    }

    public String bul() {
        return this.euo;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
