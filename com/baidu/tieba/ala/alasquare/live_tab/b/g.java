package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class g {
    public SdkLiveInfoData gyg;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.gyg = new SdkLiveInfoData();
            this.gyg.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.gyg != null && ((long) com.baidu.adp.lib.f.b.toInt(this.gyg.liveId, 0)) > 0;
    }
}
