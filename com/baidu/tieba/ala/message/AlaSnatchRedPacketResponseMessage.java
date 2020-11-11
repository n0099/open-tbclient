package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.l;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSnatchRedPacketResponseMessage extends JsonHttpResponsedMessage {
    private l hys;

    public AlaSnatchRedPacketResponseMessage() {
        super(1021161);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hys = new l();
            this.hys.parserJson(optJSONObject);
        }
    }

    public l ciD() {
        return this.hys;
    }
}
