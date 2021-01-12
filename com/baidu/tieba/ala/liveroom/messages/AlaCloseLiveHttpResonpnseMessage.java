package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaCloseLiveHttpResonpnseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.liveroom.data.b hEU;

    public AlaCloseLiveHttpResonpnseMessage() {
        super(1021036);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.hEU = new com.baidu.tieba.ala.liveroom.data.b();
            this.hEU.dW(optJSONObject);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.b chP() {
        return this.hEU;
    }
}
