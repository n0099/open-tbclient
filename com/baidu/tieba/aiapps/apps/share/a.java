package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends ShareItem {
    public void dx(JSONObject jSONObject) throws JSONException {
        this.fhm = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.fhn = optJSONObject.optString("source2");
            this.fhp = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.fho = 2;
            this.fht = optJSONObject2.optJSONArray("cmd_pannel");
            this.fhu = optJSONObject2.optJSONObject("info");
            if (this.fhu != null) {
                this.fhr = this.fhu.optString("key");
                this.fhs = this.fhu.optString("content");
                return;
            }
            return;
        }
        this.fho = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bLv() {
        return this.fht;
    }

    public String bLw() {
        return this.fhr;
    }

    public String bLx() {
        return this.fhs;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
