package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.ab;
import com.baidu.live.data.bd;
import com.baidu.live.data.bg;
import com.baidu.live.data.bk;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private ab aED;
    private bd hLe;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public ab Fp() {
        return this.aED;
    }

    public bd ciX() {
        return this.hLe;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        bg bgVar;
        bk bkVar;
        bk bkVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aED = new ab();
            this.aED.serverTime = jSONObject.optLong("time", System.currentTimeMillis());
            this.aED.parserJson(optJSONObject);
            this.aED.logId = jSONObject.optLong("logid");
            if (this.aED.mLiveInfo != null && this.aED.mLiveInfo.live_id > 0) {
                com.baidu.live.d.xf().putLong("ala_live_room_last_live_id", this.aED.mLiveInfo.live_id);
            }
            if (this.aED.mLiveInfo != null && this.aED.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aED.mLiveInfo.broadGiftMsgId;
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
                    bgVar = new bg();
                    bgVar.parseJson(optJSONObject5);
                } else {
                    bgVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    bkVar = new bk();
                    bkVar.parseJson(optJSONObject6);
                } else {
                    bkVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    bkVar2 = new bk();
                    bkVar2.parseJson(optJSONObject7);
                }
                if (bgVar != null && bkVar != null && bkVar2 != null) {
                    this.hLe = new bd();
                    this.hLe.aQf = bgVar;
                    this.hLe.aQg = bkVar;
                    this.hLe.aQh = bkVar2;
                }
            }
        }
    }
}
