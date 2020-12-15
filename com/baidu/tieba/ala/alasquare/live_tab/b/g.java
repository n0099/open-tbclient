package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    public SdkLiveInfoData grO;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.grO = new SdkLiveInfoData();
            this.grO.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.grO != null && ((long) com.baidu.adp.lib.f.b.toInt(this.grO.liveId, 0)) > 0;
    }
}
