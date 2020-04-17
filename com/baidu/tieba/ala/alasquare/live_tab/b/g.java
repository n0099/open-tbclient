package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public SdkLiveInfoData ePR;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.ePR = new SdkLiveInfoData();
            this.ePR.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.ePR != null && ((long) com.baidu.adp.lib.f.b.toInt(this.ePR.liveId, 0)) > 0;
    }
}
