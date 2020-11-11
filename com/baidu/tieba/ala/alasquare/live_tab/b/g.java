package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public SdkLiveInfoData gjW;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.gjW = new SdkLiveInfoData();
            this.gjW.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.gjW != null && ((long) com.baidu.adp.lib.f.b.toInt(this.gjW.liveId, 0)) > 0;
    }
}
