package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.data.h;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaUpdateLiveTbResponseMessage extends JsonHttpResponsedMessage {
    private h fLN;

    public h byH() {
        return this.fLN;
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
            this.fLN = new h();
            this.fLN.parseJson(jSONObject);
            setError(this.fLN.mErrorCode);
            setErrorString(this.fLN.mErrorMsg);
        }
    }
}
