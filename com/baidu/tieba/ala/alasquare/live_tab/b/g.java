package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    public SdkLiveInfoData gBe;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.gBe = new SdkLiveInfoData();
            this.gBe.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.gBe != null && ((long) com.baidu.adp.lib.f.b.toInt(this.gBe.liveId, 0)) > 0;
    }
}
