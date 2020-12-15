package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a hjE;
    private int hjF;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.hjF = -1;
        this.hjE = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hjF = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.hjE = new com.baidu.live.challenge.a();
                this.hjE.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a ccT() {
        return this.hjE;
    }

    public boolean ccV() {
        return this.hjF == 1;
    }
}
