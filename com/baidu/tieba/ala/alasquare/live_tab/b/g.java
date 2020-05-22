package com.baidu.tieba.ala.alasquare.live_tab.b;

import com.baidu.ala.data.SdkLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public SdkLiveInfoData fcF;

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("live_info")) != null) {
            this.fcF = new SdkLiveInfoData();
            this.fcF.fromJson(optJSONObject);
        }
    }

    public boolean isValid() {
        return this.fcF != null && ((long) com.baidu.adp.lib.f.b.toInt(this.fcF.liveId, 0)) > 0;
    }
}
