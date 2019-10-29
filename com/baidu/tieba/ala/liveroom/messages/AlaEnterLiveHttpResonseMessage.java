package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.i;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private i aaB;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public i uj() {
        return this.aaB;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aaB = new i();
            this.aaB.parserJson(optJSONObject);
            this.aaB.PT = jSONObject.optLong("logid");
            if (this.aaB.mLiveInfo != null && this.aaB.mLiveInfo.live_id > 0) {
                com.baidu.live.c.np().putLong("ala_live_room_last_live_id", this.aaB.mLiveInfo.live_id);
            }
            if (this.aaB.mLiveInfo != null && this.aaB.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aaB.mLiveInfo.broadGiftMsgId;
            }
        }
    }
}
