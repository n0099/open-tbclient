package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaCloseLiveHttpResonpnseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.ala.liveroom.data.b fZO;

    public AlaCloseLiveHttpResonpnseMessage() {
        super(1021036);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.fZO = new com.baidu.tieba.ala.liveroom.data.b();
            this.fZO.cV(optJSONObject);
        }
    }

    public com.baidu.tieba.ala.liveroom.data.b bEF() {
        return this.fZO;
    }
}
