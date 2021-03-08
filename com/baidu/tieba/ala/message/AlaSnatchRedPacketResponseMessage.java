package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.l;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaSnatchRedPacketResponseMessage extends JsonHttpResponsedMessage {
    private l hVt;

    public AlaSnatchRedPacketResponseMessage() {
        super(1021161);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hVt = new l();
            this.hVt.parserJson(optJSONObject);
        }
    }

    public l cmd() {
        return this.hVt;
    }
}
