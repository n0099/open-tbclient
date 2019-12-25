package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLootRedPacketResultResponseMessage extends JsonHttpResponsedMessage {
    private d fjs;

    public AlaLootRedPacketResultResponseMessage() {
        super(1021159);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fjs = new d();
            this.fjs.parserJson(optJSONObject);
        }
    }

    public d boU() {
        return this.fjs;
    }
}
