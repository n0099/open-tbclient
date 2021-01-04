package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    public SdkLiveInfoData gCN;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.gCN = new SdkLiveInfoData();
            this.gCN.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.gCN != null && ((long) com.baidu.adp.lib.f.b.toInt(this.gCN.liveId, 0)) > 0;
    }
}
