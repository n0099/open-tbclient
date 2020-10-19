package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public SdkLiveInfoData fUd;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.fUd = new SdkLiveInfoData();
            this.fUd.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.fUd != null && ((long) com.baidu.adp.lib.f.b.toInt(this.fUd.liveId, 0)) > 0;
    }
}
