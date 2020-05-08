package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public SdkLiveInfoData ePW;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.ePW = new SdkLiveInfoData();
            this.ePW.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.ePW != null && ((long) com.baidu.adp.lib.f.b.toInt(this.ePW.liveId, 0)) > 0;
    }
}
