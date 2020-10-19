package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.ar;
import com.baidu.live.data.au;
import com.baidu.live.data.ay;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private u aDU;
    private ar gWH;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public u Gm() {
        return this.aDU;
    }

    public ar cad() {
        return this.gWH;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        au auVar;
        ay ayVar;
        ay ayVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aDU = new u();
            this.aDU.parserJson(optJSONObject);
            this.aDU.logId = jSONObject.optLong("logid");
            if (this.aDU.mLiveInfo != null && this.aDU.mLiveInfo.live_id > 0) {
                com.baidu.live.c.AZ().putLong("ala_live_room_last_live_id", this.aDU.mLiveInfo.live_id);
            }
            if (this.aDU.mLiveInfo != null && this.aDU.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aDU.mLiveInfo.broadGiftMsgId;
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
                    auVar = new au();
                    auVar.parseJson(optJSONObject5);
                } else {
                    auVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    ayVar = new ay();
                    ayVar.parseJson(optJSONObject6);
                } else {
                    ayVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    ayVar2 = new ay();
                    ayVar2.parseJson(optJSONObject7);
                }
                if (auVar != null && ayVar != null && ayVar2 != null) {
                    this.gWH = new ar();
                    this.gWH.aMK = auVar;
                    this.gWH.aML = ayVar;
                    this.gWH.aMM = ayVar2;
                }
            }
        }
    }
}
