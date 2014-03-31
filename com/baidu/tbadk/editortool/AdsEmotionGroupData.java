package com.baidu.tbadk.editortool;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AdsEmotionGroupData implements y, Serializable {
    private static final long serialVersionUID = 1;
    private String colorCoverUrl;
    private String groupId;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.groupId = jSONObject.optString("pid");
            this.colorCoverUrl = jSONObject.optString("recmd_url");
        }
    }

    @Override // com.baidu.tbadk.editortool.y
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

    @Override // com.baidu.tbadk.editortool.y
    public boolean IsValid() {
        return !TextUtils.isEmpty(this.colorCoverUrl);
    }
}
