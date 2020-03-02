package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLootRedPacketResultResponseMessage extends JsonHttpResponsedMessage {
    private d fpg;

    public AlaLootRedPacketResultResponseMessage() {
        super(1021162);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fpg = new d();
            this.fpg.parserJson(optJSONObject);
        }
    }

    public d brB() {
        return this.fpg;
    }
}
