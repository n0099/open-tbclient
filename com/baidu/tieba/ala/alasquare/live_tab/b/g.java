package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public SdkLiveInfoData gjD;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.gjD = new SdkLiveInfoData();
            this.gjD.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.gjD != null && ((long) com.baidu.adp.lib.f.b.toInt(this.gjD.liveId, 0)) > 0;
    }
}
