package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public SdkLiveInfoData fED;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.fED = new SdkLiveInfoData();
            this.fED.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.fED != null && ((long) com.baidu.adp.lib.f.b.toInt(this.fED.liveId, 0)) > 0;
    }
}
