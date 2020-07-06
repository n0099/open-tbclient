package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.aj;
import com.baidu.live.data.am;
import com.baidu.live.data.aq;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private q aLQ;
    private aj gmN;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public q FU() {
        return this.aLQ;
    }

    public aj bHO() {
        return this.gmN;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        am amVar;
        aq aqVar;
        aq aqVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aLQ = new q();
            this.aLQ.parserJson(optJSONObject);
            this.aLQ.axR = jSONObject.optLong("logid");
            if (this.aLQ.mLiveInfo != null && this.aLQ.mLiveInfo.live_id > 0) {
                com.baidu.live.c.vf().putLong("ala_live_room_last_live_id", this.aLQ.mLiveInfo.live_id);
            }
            if (this.aLQ.mLiveInfo != null && this.aLQ.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aLQ.mLiveInfo.broadGiftMsgId;
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject3 != null) {
                AlaLiveSwitchData.isHotLive = optJSONObject3.optInt(HttpRequest.SDK_LIVE_IS_HOT);
                AlaLiveSwitchData.liveActivityType = optJSONObject3.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("challenge_info");
            if (optJSONObject4 != null && (optJSONObject2 = optJSONObject4.optJSONObject("data")) != null) {
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject("challenge_info");
                if (optJSONObject5 != null) {
                    amVar = new am();
                    amVar.parseJson(optJSONObject5);
                } else {
                    amVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    aqVar = new aq();
                    aqVar.parseJson(optJSONObject6);
                } else {
                    aqVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    aqVar2 = new aq();
                    aqVar2.parseJson(optJSONObject7);
                }
                if (amVar != null && aqVar != null && aqVar2 != null) {
                    this.gmN = new aj();
                    this.gmN.aBD = amVar;
                    this.gmN.aBE = aqVar;
                    this.gmN.aBF = aqVar2;
                }
            }
        }
    }
}
