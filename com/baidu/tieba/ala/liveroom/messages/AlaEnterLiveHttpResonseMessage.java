package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.ak;
import com.baidu.live.data.an;
import com.baidu.live.data.ar;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private q avf;
    private ak grL;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public q FO() {
        return this.avf;
    }

    public ak bKU() {
        return this.grL;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        an anVar;
        ar arVar;
        ar arVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.avf = new q();
            this.avf.parserJson(optJSONObject);
            this.avf.aze = jSONObject.optLong("logid");
            if (this.avf.mLiveInfo != null && this.avf.mLiveInfo.live_id > 0) {
                com.baidu.live.c.vf().putLong("ala_live_room_last_live_id", this.avf.mLiveInfo.live_id);
            }
            if (this.avf.mLiveInfo != null && this.avf.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.avf.mLiveInfo.broadGiftMsgId;
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
                    anVar = new an();
                    anVar.parseJson(optJSONObject5);
                } else {
                    anVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    arVar = new ar();
                    arVar.parseJson(optJSONObject6);
                } else {
                    arVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    arVar2 = new ar();
                    arVar2.parseJson(optJSONObject7);
                }
                if (anVar != null && arVar != null && arVar2 != null) {
                    this.grL = new ak();
                    this.grL.aCY = anVar;
                    this.grL.aCZ = arVar;
                    this.grL.aDa = arVar2;
                }
            }
        }
    }
}
