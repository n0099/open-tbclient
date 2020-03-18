package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a eUY;
    private int eUZ;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eUZ = optJSONObject.optInt("cancel_status");
            this.eUY = new com.baidu.live.challenge.a();
            this.eUY.parseJson(optJSONObject.optJSONObject("match_info"));
        }
    }

    public com.baidu.live.challenge.a bkt() {
        return this.eUY;
    }

    public boolean bkv() {
        return this.eUZ == 1;
    }
}
