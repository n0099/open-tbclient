package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.m;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private m alp;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public m yT() {
        return this.alp;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.alp = new m();
            this.alp.parserJson(optJSONObject);
            this.alp.Yw = jSONObject.optLong("logid");
            if (this.alp.mLiveInfo != null && this.alp.mLiveInfo.live_id > 0) {
                com.baidu.live.c.pw().putLong("ala_live_room_last_live_id", this.alp.mLiveInfo.live_id);
            }
            if (this.alp.mLiveInfo != null && this.alp.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.alp.mLiveInfo.broadGiftMsgId;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                AlaLiveSwitchData.isHotLive = optJSONObject2.optInt(HttpRequest.SDK_LIVE_IS_HOT);
                AlaLiveSwitchData.liveActivityType = optJSONObject2.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
            }
        }
    }
}
