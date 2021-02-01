package com.baidu.tieba.faceshop;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AdsEmotionGroupData implements com.baidu.tieba.face.data.b, Serializable {
    private static final long serialVersionUID = 1;
    private String colorCoverUrl;
    private String groupId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.groupId = jSONObject.optString("pid");
            this.colorCoverUrl = jSONObject.optString("recmd_url");
        }
    }

    @Override // com.baidu.tieba.face.data.b
    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getColorCoverUrl() {
        return this.colorCoverUrl;
    }

    public void setColorCoverUrl(String str) {
        this.colorCoverUrl = str;
    }

    @Override // com.baidu.tieba.face.data.b
    public boolean IsValid() {
        return !TextUtils.isEmpty(this.colorCoverUrl);
    }
}
