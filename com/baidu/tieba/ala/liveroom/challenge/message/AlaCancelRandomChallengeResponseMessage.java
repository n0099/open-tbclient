package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a hqT;
    private int hqU;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.hqU = -1;
        this.hqT = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hqU = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.hqT = new com.baidu.live.challenge.a();
                this.hqT.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a cbS() {
        return this.hqT;
    }

    public boolean cbU() {
        return this.hqU == 1;
    }
}
