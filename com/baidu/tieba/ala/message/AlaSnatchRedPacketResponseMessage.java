package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.i;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaSnatchRedPacketResponseMessage extends JsonHttpResponsedMessage {
    private i fjt;

    public AlaSnatchRedPacketResponseMessage() {
        super(1021158);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fjt = new i();
            this.fjt.parserJson(optJSONObject);
        }
    }

    public i boV() {
        return this.fjt;
    }
}
