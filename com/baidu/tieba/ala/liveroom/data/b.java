package com.baidu.tieba.ala.liveroom.data;

import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public AlaLiveUserInfoData aEz;
    public AlaLiveInfoData mLiveInfo;

    public void dB(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aEz = new AlaLiveUserInfoData();
                this.aEz.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                this.mLiveInfo = new AlaLiveInfoData();
                this.mLiveInfo.parserJson(optJSONObject2);
            }
        }
    }
}
