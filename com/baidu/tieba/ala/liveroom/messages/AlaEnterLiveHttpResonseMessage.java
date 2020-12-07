package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.ax;
import com.baidu.live.data.ba;
import com.baidu.live.data.be;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private w aFN;
    private ax hxB;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public w Iq() {
        return this.aFN;
    }

    public ax ciV() {
        return this.hxB;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ba baVar;
        be beVar;
        be beVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aFN = new w();
            this.aFN.serverTime = jSONObject.optLong("time", System.currentTimeMillis());
            this.aFN.parserJson(optJSONObject);
            this.aFN.logId = jSONObject.optLong("logid");
            if (this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.live_id > 0) {
                com.baidu.live.d.BM().putLong("ala_live_room_last_live_id", this.aFN.mLiveInfo.live_id);
            }
            if (this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aFN.mLiveInfo.broadGiftMsgId;
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
                    baVar = new ba();
                    baVar.parseJson(optJSONObject5);
                } else {
                    baVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    beVar = new be();
                    beVar.parseJson(optJSONObject6);
                } else {
                    beVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    beVar2 = new be();
                    beVar2.parseJson(optJSONObject7);
                }
                if (baVar != null && beVar != null && beVar2 != null) {
                    this.hxB = new ax();
                    this.hxB.aPG = baVar;
                    this.hxB.aPH = beVar;
                    this.hxB.aPI = beVar2;
                }
            }
        }
    }
}
