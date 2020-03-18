package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int eUX;
    private com.baidu.live.challenge.a eUY;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eUX = optJSONObject.optInt("accept_status");
            this.eUY = new com.baidu.live.challenge.a();
            this.eUY.parseJson(optJSONObject.optJSONObject("match_info"));
        }
    }

    public com.baidu.live.challenge.a bkt() {
        return this.eUY;
    }

    public boolean bku() {
        return this.eUX == 1;
    }
}
