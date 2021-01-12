package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.az;
import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private x aBr;
    private az hEV;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public x DW() {
        return this.aBr;
    }

    public az chR() {
        return this.hEV;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        bc bcVar;
        bg bgVar;
        bg bgVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aBr = new x();
            this.aBr.serverTime = jSONObject.optLong("time", System.currentTimeMillis());
            this.aBr.parserJson(optJSONObject);
            this.aBr.logId = jSONObject.optLong("logid");
            if (this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.live_id > 0) {
                com.baidu.live.d.xf().putLong("ala_live_room_last_live_id", this.aBr.mLiveInfo.live_id);
            }
            if (this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aBr.mLiveInfo.broadGiftMsgId;
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
                    bcVar = new bc();
                    bcVar.parseJson(optJSONObject5);
                } else {
                    bcVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    bgVar = new bg();
                    bgVar.parseJson(optJSONObject6);
                } else {
                    bgVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    bgVar2 = new bg();
                    bgVar2.parseJson(optJSONObject7);
                }
                if (bcVar != null && bgVar != null && bgVar2 != null) {
                    this.hEV = new az();
                    this.hEV.aLI = bcVar;
                    this.hEV.aLJ = bgVar;
                    this.hEV.aLK = bgVar2;
                }
            }
        }
    }
}
