package com.baidu.tieba.faceshop;

import android.text.TextUtils;
import d.a.k0.k0.c.b;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdsEmotionGroupData implements Serializable, b {
    public static final long serialVersionUID = 1;
    public String colorCoverUrl;
    public String groupId;

    @Override // d.a.k0.k0.c.b
    public boolean IsValid() {
        return !TextUtils.isEmpty(this.colorCoverUrl);
    }

    public String getColorCoverUrl() {
        return this.colorCoverUrl;
    }

    @Override // d.a.k0.k0.c.b
    public String getGroupId() {
        return this.groupId;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.groupId = jSONObject.optString("pid");
        this.colorCoverUrl = jSONObject.optString("recmd_url");
    }

    public void setColorCoverUrl(String str) {
        this.colorCoverUrl = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
