package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.i;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private i aaj;

    public AlaEnterLiveHttpResonseMessage() {
        super(1021005);
    }

    public i uk() {
        return this.aaj;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.aaj = new i();
            this.aaj.parserJson(optJSONObject);
            this.aaj.Po = jSONObject.optLong("logid");
            if (this.aaj.mLiveInfo != null && this.aaj.mLiveInfo.live_id > 0) {
                com.baidu.live.c.np().putLong("ala_live_room_last_live_id", this.aaj.mLiveInfo.live_id);
            }
            if (this.aaj.mLiveInfo != null && this.aaj.mLiveInfo.broadGiftMsgId > 0) {
                com.baidu.live.gift.a.broadGiftMsgId = this.aaj.mLiveInfo.broadGiftMsgId;
            }
        }
    }
}
