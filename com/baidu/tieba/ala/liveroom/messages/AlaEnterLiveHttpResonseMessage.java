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
    private w aES;
    private aw hoo;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public w Hi() {
        return this.aES;
    }

    public aw cfI() {
        return this.hoo;
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
            this.aES = new w();
            this.aES.serverTime = jSONObject.optLong("time", System.currentTimeMillis());
            this.aES.parserJson(optJSONObject);
            this.aES.logId = jSONObject.optLong("logid");
            if (this.aES.mLiveInfo != null && this.aES.mLiveInfo.live_id > 0) {
                com.baidu.live.d.AZ().putLong("ala_live_room_last_live_id", this.aES.mLiveInfo.live_id);
            }
            if (this.aES.mLiveInfo != null && this.aES.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aES.mLiveInfo.broadGiftMsgId;
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
                    this.hoo = new aw();
                    this.hoo.aOs = azVar;
                    this.hoo.aOt = bdVar;
                    this.hoo.aOu = bdVar2;
                }
            }
        }
    }
}
