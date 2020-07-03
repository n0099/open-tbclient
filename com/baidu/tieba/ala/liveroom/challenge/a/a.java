package com.baidu.tieba.ala.liveroom.challenge.a;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.data.AlaLiveUserInfoData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public AlaLiveUserInfoData aBG;
    public int rank;
    public String score;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aBG = new AlaLiveUserInfoData();
                this.aBG.parserJson(optJSONObject);
            }
            this.rank = jSONObject.optInt("rank");
            this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
        }
    }
}
