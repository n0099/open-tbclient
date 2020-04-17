package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.ad;
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private n aDE;
    private ad fLB;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public n DN() {
        return this.aDE;
    }

    public ad byE() {
        return this.fLB;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ag agVar;
        ah ahVar;
        ah ahVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aDE = new n();
            this.aDE.parserJson(optJSONObject);
            this.aDE.aqG = jSONObject.optLong("logid");
            if (this.aDE.mLiveInfo != null && this.aDE.mLiveInfo.live_id > 0) {
                com.baidu.live.c.tH().putLong("ala_live_room_last_live_id", this.aDE.mLiveInfo.live_id);
            }
            if (this.aDE.mLiveInfo != null && this.aDE.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aDE.mLiveInfo.broadGiftMsgId;
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
                    agVar = new ag();
                    agVar.parseJson(optJSONObject5);
                } else {
                    agVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    ahVar = new ah();
                    ahVar.parseJson(optJSONObject6);
                } else {
                    ahVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    ahVar2 = new ah();
                    ahVar2.parseJson(optJSONObject7);
                }
                if (agVar != null && ahVar != null && ahVar2 != null) {
                    this.fLB = new ad();
                    this.fLB.aub = agVar;
                    this.fLB.auc = ahVar;
                    this.fLB.aud = ahVar2;
                }
            }
        }
    }
}
