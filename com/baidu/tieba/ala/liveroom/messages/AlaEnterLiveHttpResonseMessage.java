package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.au;
import com.baidu.live.data.ax;
import com.baidu.live.data.bb;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private w aEc;
    private au hix;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public w GH() {
        return this.aEc;
    }

    public au cdh() {
        return this.hix;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ax axVar;
        bb bbVar;
        bb bbVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aEc = new w();
            this.aEc.serverTime = jSONObject.optLong("time", System.currentTimeMillis());
            this.aEc.parserJson(optJSONObject);
            this.aEc.logId = jSONObject.optLong("logid");
            if (this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.live_id > 0) {
                com.baidu.live.d.AZ().putLong("ala_live_room_last_live_id", this.aEc.mLiveInfo.live_id);
            }
            if (this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aEc.mLiveInfo.broadGiftMsgId;
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
                    axVar = new ax();
                    axVar.parseJson(optJSONObject5);
                } else {
                    axVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    bbVar = new bb();
                    bbVar.parseJson(optJSONObject6);
                } else {
                    bbVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    bbVar2 = new bb();
                    bbVar2.parseJson(optJSONObject7);
                }
                if (axVar != null && bbVar != null && bbVar2 != null) {
                    this.hix = new au();
                    this.hix.aNp = axVar;
                    this.hix.aNq = bbVar;
                    this.hix.aNr = bbVar2;
                }
            }
        }
    }
}
