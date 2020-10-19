package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends ShareItem {
    /* renamed from: do  reason: not valid java name */
    public void m39do(JSONObject jSONObject) throws JSONException {
        this.eSZ = true;
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUrl = jSONObject.optString("imageUrl");
        this.mediaType = jSONObject.optString("mediaType");
        this.imageUrl = StringUtils.isNull(this.imageUrl) ? jSONObject.optString("iconUrl") : this.imageUrl;
        this.imageUri = Uri.parse(this.imageUrl);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.eTa = optJSONObject.optString("source2");
            this.eTc = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.eTb = 2;
            this.eTg = optJSONObject2.optJSONArray("cmd_pannel");
            this.eTh = optJSONObject2.optJSONObject("info");
            if (this.eTh != null) {
                this.eTe = this.eTh.optString("key");
                this.eTf = this.eTh.optString("content");
                return;
            }
            return;
        }
        this.eTb = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }

    public JSONArray bHd() {
        return this.eTg;
    }

    public String bHe() {
        return this.eTe;
    }

    public String bHf() {
        return this.eTf;
    }

    public String getMediaType() {
        return this.mediaType;
    }
}
