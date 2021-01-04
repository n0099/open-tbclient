package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.az;
import com.baidu.live.data.bc;
import com.baidu.live.data.bg;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private x aGe;
    private az hJB;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public x HR() {
        return this.aGe;
    }

    public az clI() {
        return this.hJB;
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
            this.aGe = new x();
            this.aGe.serverTime = jSONObject.optLong("time", System.currentTimeMillis());
            this.aGe.parserJson(optJSONObject);
            this.aGe.logId = jSONObject.optLong("logid");
            if (this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.live_id > 0) {
                com.baidu.live.d.Ba().putLong("ala_live_room_last_live_id", this.aGe.mLiveInfo.live_id);
            }
            if (this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aGe.mLiveInfo.broadGiftMsgId;
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
                    this.hJB = new az();
                    this.hJB.aQv = bcVar;
                    this.hJB.aQw = bgVar;
                    this.hJB.aQx = bgVar2;
                }
            }
        }
    }
}
