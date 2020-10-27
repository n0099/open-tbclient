package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public SdkLiveInfoData geg;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.geg = new SdkLiveInfoData();
            this.geg.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.geg != null && ((long) com.baidu.adp.lib.f.b.toInt(this.geg.liveId, 0)) > 0;
    }
}
