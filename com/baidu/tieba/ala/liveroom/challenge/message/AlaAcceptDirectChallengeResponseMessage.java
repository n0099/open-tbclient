package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaAcceptDirectChallengeResponseMessage extends JsonHttpResponsedMessage {
    private int hjB;
    private com.baidu.live.challenge.a hjC;

    public AlaAcceptDirectChallengeResponseMessage() {
        super(1021109);
        this.hjB = -1;
        this.hjC = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hjB = optJSONObject.optInt("accept_status", -1);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.hjC = new com.baidu.live.challenge.a();
                this.hjC.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a ccS() {
        return this.hjC;
    }

    public boolean ccT() {
        return this.hjB == 1;
    }
}
