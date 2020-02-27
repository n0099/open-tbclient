package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RedPktSendHttpResponseMessage extends JsonHttpResponsedMessage {
    public long eAn;
    public long eAo;

    public RedPktSendHttpResponseMessage() {
        super(1021159);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eAn = optJSONObject.optLong("red_packet_id");
            this.eAo = optJSONObject.optLong("red_packet_balance");
        }
    }
}
