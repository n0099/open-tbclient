package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.data.h;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class LiveBackstageHttpResonpnseMessage extends JsonHttpResponsedMessage {
    private h ekC;

    public LiveBackstageHttpResonpnseMessage() {
        super(1021123);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.ekC = new h();
            this.ekC.parserJson(optJSONObject);
        }
    }
}
