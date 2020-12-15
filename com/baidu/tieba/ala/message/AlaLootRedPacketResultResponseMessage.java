package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.e;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLootRedPacketResultResponseMessage extends JsonHttpResponsedMessage {
    private e hHF;

    public AlaLootRedPacketResultResponseMessage() {
        super(1021162);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hHF = new e();
            this.hHF.parserJson(optJSONObject);
        }
    }

    public e clR() {
        return this.hHF;
    }
}
