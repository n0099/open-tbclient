package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaCloseLiveHttpResonpnseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.liveroom.data.b gEE;

    public AlaCloseLiveHttpResonpnseMessage() {
        super(1021036);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.gEE = new com.baidu.tieba.ala.liveroom.data.b();
            this.gEE.dv(optJSONObject);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.b bUV() {
        return this.gEE;
    }
}
