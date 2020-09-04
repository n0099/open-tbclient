package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.am;
import com.baidu.live.data.ap;
import com.baidu.live.data.at;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private r aAj;
    private am gEJ;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public r LC() {
        return this.aAj;
    }

    public am bUY() {
        return this.gEJ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ap apVar;
        at atVar;
        at atVar2 = null;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aAj = new r();
            this.aAj.parserJson(optJSONObject);
            this.aAj.aEo = jSONObject.optLong("logid");
            if (this.aAj.mLiveInfo != null && this.aAj.mLiveInfo.live_id > 0) {
                com.baidu.live.c.AD().putLong("ala_live_room_last_live_id", this.aAj.mLiveInfo.live_id);
            }
            if (this.aAj.mLiveInfo != null && this.aAj.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aAj.mLiveInfo.broadGiftMsgId;
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
                    apVar = new ap();
                    apVar.parseJson(optJSONObject5);
                } else {
                    apVar = null;
                }
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("anchor_info");
                if (optJSONObject6 != null) {
                    atVar = new at();
                    atVar.parseJson(optJSONObject6);
                } else {
                    atVar = null;
                }
                JSONObject optJSONObject7 = optJSONObject2.optJSONObject("rival_info");
                if (optJSONObject7 != null) {
                    atVar2 = new at();
                    atVar2.parseJson(optJSONObject7);
                }
                if (apVar != null && atVar != null && atVar2 != null) {
                    this.gEJ = new am();
                    this.gEJ.aIk = apVar;
                    this.gEJ.aIl = atVar;
                    this.gEJ.aIm = atVar2;
                }
            }
        }
    }
}
