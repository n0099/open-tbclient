package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRedPacketInfoResponseMessage extends JsonHttpResponsedMessage {
    private c hHA;

    public AlaGetRedPacketInfoResponseMessage() {
        super(1021160);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hHA = new c();
            this.hHA.parserJson(optJSONObject);
        }
    }

    public c clP() {
        return this.hHA;
    }
}
