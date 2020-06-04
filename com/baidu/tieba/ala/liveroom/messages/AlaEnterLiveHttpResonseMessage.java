package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.ah;
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private q aJj;
    private ah fZP;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public q Fk() {
        return this.aJj;
    }

    public ah bEH() {
        return this.fZP;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ak akVar;
        al alVar;
        al alVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aJj = new q();
            this.aJj.parserJson(optJSONObject);
            this.aJj.avL = jSONObject.optLong("logid");
            if (this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.live_id > 0) {
                com.baidu.live.c.uN().putLong("ala_live_room_last_live_id", this.aJj.mLiveInfo.live_id);
            }
            if (this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aJj.mLiveInfo.broadGiftMsgId;
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
                    akVar = new ak();
                    akVar.parseJson(optJSONObject5);
                } else {
                    akVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    alVar = new al();
                    alVar.parseJson(optJSONObject6);
                } else {
                    alVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    alVar2 = new al();
                    alVar2.parseJson(optJSONObject7);
                }
                if (akVar != null && alVar != null && alVar2 != null) {
                    this.fZP = new ah();
                    this.fZP.azl = akVar;
                    this.fZP.azm = alVar;
                    this.fZP.azn = alVar2;
                }
            }
        }
    }
}
