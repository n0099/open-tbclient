package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public SdkLiveInfoData elM;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.elM = new SdkLiveInfoData();
            this.elM.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.elM != null && ((long) com.baidu.adp.lib.f.b.toInt(this.elM.liveId, 0)) > 0;
    }
}
