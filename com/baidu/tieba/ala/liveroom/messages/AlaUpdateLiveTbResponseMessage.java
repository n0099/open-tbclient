package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.data.h;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaUpdateLiveTbResponseMessage extends JsonHttpResponsedMessage {
    private h gnb;

    public h bHS() {
        return this.gnb;
    }

    public AlaUpdateLiveTbResponseMessage() {
        super(1021033);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("live_info")) != null) {
                AlaLiveSwitchData.liveActivityType = optJSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
            }
            this.gnb = new h();
            this.gnb.parseJson(jSONObject);
            setError(this.gnb.mErrorCode);
            setErrorString(this.gnb.mErrorMsg);
        }
    }
}
