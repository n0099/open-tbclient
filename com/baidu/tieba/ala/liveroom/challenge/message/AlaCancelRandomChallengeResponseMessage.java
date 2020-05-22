package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaCancelRandomChallengeResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.live.challenge.a fNy;
    private int fNz;

    public AlaCancelRandomChallengeResponseMessage() {
        super(1021111);
        this.fNz = -1;
        this.fNy = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fNz = optJSONObject.optInt("cancel_status");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("match_info");
            if (optJSONObject2 != null) {
                this.fNy = new com.baidu.live.challenge.a();
                this.fNy.parseJson(optJSONObject2);
            }
        }
    }

    public com.baidu.live.challenge.a bzJ() {
        return this.fNy;
    }

    public boolean bzL() {
        return this.fNz == 1;
    }
}
