package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class RedPktSendHttpResponseMessage extends JsonHttpResponsedMessage {
    public long gQx;
    public long gQy;

    public RedPktSendHttpResponseMessage() {
        super(1021159);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gQx = optJSONObject.optLong("red_packet_id");
            this.gQy = optJSONObject.optLong("red_packet_balance");
        }
    }
}
