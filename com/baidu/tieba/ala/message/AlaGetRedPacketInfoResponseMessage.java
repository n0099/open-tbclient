package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetRedPacketInfoResponseMessage extends JsonHttpResponsedMessage {
    private b gjj;

    public AlaGetRedPacketInfoResponseMessage() {
        super(1021160);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gjj = new b();
            this.gjj.parserJson(optJSONObject);
        }
    }

    public b bHB() {
        return this.gjj;
    }
}
