package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public SdkLiveInfoData fHT;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.fHT = new SdkLiveInfoData();
            this.fHT.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.fHT != null && ((long) com.baidu.adp.lib.f.b.toInt(this.fHT.liveId, 0)) > 0;
    }
}
