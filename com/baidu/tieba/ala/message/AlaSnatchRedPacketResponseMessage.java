package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.i;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaSnatchRedPacketResponseMessage extends JsonHttpResponsedMessage {
    private i gjn;

    public AlaSnatchRedPacketResponseMessage() {
        super(1021161);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gjn = new i();
            this.gjn.parserJson(optJSONObject);
        }
    }

    public i bHD() {
        return this.gjn;
    }
}
