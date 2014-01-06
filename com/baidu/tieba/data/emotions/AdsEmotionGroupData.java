package com.baidu.tieba.data.emotions;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AdsEmotionGroupData implements Serializable {
    private String colorCoverUrl;
    private String groupId;

    public void parseJsonFromSyncService(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.groupId = jSONObject.optString("pid");
            this.colorCoverUrl = jSONObject.optString("recmd_url");
        }
    }

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
}
