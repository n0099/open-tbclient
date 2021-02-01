package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends ShareItem {
    public void dC(JSONObject jSONObject) throws JSONException {
        this.fvn = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.fvo = optJSONObject.optString("source2");
            this.fvq = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.fvp = 2;
            this.fvu = optJSONObject2.optJSONArray("cmd_pannel");
            this.fvv = optJSONObject2.optJSONObject("info");
            if (this.fvv != null) {
                this.fvs = this.fvv.optString("key");
                this.fvt = this.fvv.optString("content");
                return;
            }
            return;
        }
        this.fvp = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bNz() {
        return this.fvu;
    }

    public String bNA() {
        return this.fvs;
    }

    public String bNB() {
        return this.fvt;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
