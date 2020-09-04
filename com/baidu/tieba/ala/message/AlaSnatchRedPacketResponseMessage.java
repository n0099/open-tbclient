package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.j;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaSnatchRedPacketResponseMessage extends JsonHttpResponsedMessage {
    private j gOj;

    public AlaSnatchRedPacketResponseMessage() {
        super(1021161);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gOj = new j();
            this.gOj.parserJson(optJSONObject);
        }
    }

    public j bXR() {
        return this.gOj;
    }
}
