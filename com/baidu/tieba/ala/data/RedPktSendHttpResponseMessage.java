package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RedPktSendHttpResponseMessage extends JsonHttpResponsedMessage {
    public long euR;
    public long euS;

    public RedPktSendHttpResponseMessage() {
        super(1021156);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.euR = optJSONObject.optLong("red_packet_id");
            this.euS = optJSONObject.optLong("red_packet_balance");
        }
    }
}
