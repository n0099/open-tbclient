package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.aw;
import com.baidu.live.data.az;
import com.baidu.live.data.bd;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private w aDh;
    private aw hnV;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public w Gz() {
        return this.aDh;
    }

    public aw cfb() {
        return this.hnV;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        az azVar;
        bd bdVar;
        bd bdVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aDh = new w();
            this.aDh.serverTime = jSONObject.optLong("time", System.currentTimeMillis());
            this.aDh.parserJson(optJSONObject);
            this.aDh.logId = jSONObject.optLong("logid");
            if (this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.live_id > 0) {
                com.baidu.live.d.Aq().putLong("ala_live_room_last_live_id", this.aDh.mLiveInfo.live_id);
            }
            if (this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aDh.mLiveInfo.broadGiftMsgId;
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
                    azVar = new az();
                    azVar.parseJson(optJSONObject5);
                } else {
                    azVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    bdVar = new bd();
                    bdVar.parseJson(optJSONObject6);
                } else {
                    bdVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    bdVar2 = new bd();
                    bdVar2.parseJson(optJSONObject7);
                }
                if (azVar != null && bdVar != null && bdVar2 != null) {
                    this.hnV = new aw();
                    this.hnV.aMH = azVar;
                    this.hnV.aMI = bdVar;
                    this.hnV.aMJ = bdVar2;
                }
            }
        }
    }
}
