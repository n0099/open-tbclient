package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    public SdkLiveInfoData grM;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.grM = new SdkLiveInfoData();
            this.grM.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.grM != null && ((long) com.baidu.adp.lib.f.b.toInt(this.grM.liveId, 0)) > 0;
    }
}
