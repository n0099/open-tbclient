package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public SdkLiveInfoData elN;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.elN = new SdkLiveInfoData();
            this.elN.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.elN != null && ((long) com.baidu.adp.lib.f.b.toInt(this.elN.liveId, 0)) > 0;
    }
}
